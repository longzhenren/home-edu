package com.amur.home.ai.service.impl;

import com.amur.home.ai.client.DashScopeClient;
import com.amur.home.ai.config.AiServiceConfig;
import com.amur.home.ai.entity.AiChatRequest;
import com.amur.home.ai.entity.AiChatResponse;
import com.amur.home.ai.entity.AiConversation;
import com.amur.home.ai.entity.AiMessage;
import com.amur.home.ai.mapper.AiConversationMapper;
import com.amur.home.ai.mapper.AiMessageMapper;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.springframework.data.redis.core.ListOperations;

@ExtendWith(MockitoExtension.class)
class AiChatServiceImplTest {

    @InjectMocks
    private AiChatServiceImpl aiChatService;

    @Mock
    private DashScopeClient dashScopeClient;

    @Mock
    private AiServiceConfig config;

    @Mock
    private AiConversationMapper conversationMapper;

    @Mock
    private AiMessageMapper messageMapper;

    @Mock
    private StringRedisTemplate redisTemplate;



    @Test
    @DisplayName("正常对话 - 新会话自动创建")
    void testChat_NewConversation() throws Exception {
        Long userId = 1L;
        AiChatRequest request = new AiChatRequest();
        request.setMessage("什么是勾股定理？");
        request.setModuleType("homework");

        when(conversationMapper.insert(any(AiConversation.class))).thenAnswer(i -> {
            AiConversation c = i.getArgument(0);
            c.setId(100L);
            return 1;
        });
        when(conversationMapper.selectById(100L)).thenReturn(new AiConversation());
        when(messageMapper.insert(any(AiMessage.class))).thenReturn(1);
        when(messageMapper.selectList(any(QueryWrapper.class))).thenReturn(Collections.emptyList());
        when(redisTemplate.opsForList()).thenReturn(mock(ListOperations.class));

        DashScopeClient.ChatResponse apiResp = new DashScopeClient.ChatResponse();
        DashScopeClient.ChatResponse.Choice choice = new DashScopeClient.ChatResponse.Choice();
        DashScopeClient.ChatResponse.Choice.Message msg = new DashScopeClient.ChatResponse.Choice.Message();
        msg.setContent("勾股定理是直角三角形三边的关系...");
        msg.setRole("assistant");
        choice.setMessage(msg);
        apiResp.setChoices(Collections.singletonList(choice));
        DashScopeClient.ChatResponse.Usage usage = new DashScopeClient.ChatResponse.Usage();
        usage.setTotalTokens(50);
        apiResp.setUsage(usage);
        when(dashScopeClient.chat(anyList())).thenReturn(apiResp);
        when(config.getModel()).thenReturn("qwen-plus");

        ServiceResult<AiChatResponse> result = aiChatService.chat(userId, request);

        assertTrue(result.isSuccess());
        assertNotNull(result.getData());
        assertEquals("勾股定理是直角三角形三边的关系...", result.getData().getReply());
        assertEquals(50, result.getData().getTokenCount());
    }

    @Test
    @DisplayName("空消息应拒绝")
    void testChat_EmptyMessage() {
        AiChatRequest request = new AiChatRequest();
        request.setMessage("");

        ServiceResult<AiChatResponse> result = aiChatService.chat(1L, request);

        assertFalse(result.isSuccess());
        assertEquals("消息不能为空", result.getMessage());
    }

    @Test
    @DisplayName("创建对话")
    void testCreateConversation() {
        when(conversationMapper.insert(any(AiConversation.class))).thenAnswer(i -> {
            AiConversation c = i.getArgument(0);
            c.setId(200L);
            return 1;
        });

        ServiceResult<Long> result = aiChatService.createConversation(1L, "homework", "数学作业");

        assertTrue(result.isSuccess());
        assertEquals(200L, result.getData());
    }

    @Test
    @DisplayName("删除对话")
    void testDeleteConversation() {
        AiConversation conv = new AiConversation();
        conv.setId(1L);
        when(conversationMapper.selectById(1L)).thenReturn(conv);
        when(conversationMapper.updateById(any(AiConversation.class))).thenReturn(1);

        ServiceResult<Boolean> result = aiChatService.deleteConversation(1L);

        assertTrue(result.isSuccess());
        assertTrue(result.getData());
        verify(redisTemplate).delete(eq("ai:conversation:1"));
    }

    @Test
    @DisplayName("删除不存在的对话")
    void testDeleteNonExistentConversation() {
        when(conversationMapper.selectById(999L)).thenReturn(null);

        ServiceResult<Boolean> result = aiChatService.deleteConversation(999L);

        assertFalse(result.isSuccess());
        assertEquals("对话不存在", result.getMessage());
    }

    @Test
    @DisplayName("获取对话历史")
    void testGetConversationHistory() {
        List<AiMessage> messages = new ArrayList<>();
        AiMessage m1 = new AiMessage();
        m1.setSender(1);
        m1.setContent("你好");
        m1.setTokenCount(10);
        m1.setResponseTimeMs(100L);
        messages.add(m1);
        AiMessage m2 = new AiMessage();
        m2.setSender(2);
        m2.setContent("你好！有什么可以帮你的？");
        m2.setTokenCount(20);
        m2.setResponseTimeMs(200L);
        messages.add(m2);
        when(messageMapper.selectList(any(QueryWrapper.class))).thenReturn(messages);

        ServiceResult<List<AiChatResponse>> result = aiChatService.getConversationHistory(1L);

        assertTrue(result.isSuccess());
        assertEquals(2, result.getData().size());
    }
}
