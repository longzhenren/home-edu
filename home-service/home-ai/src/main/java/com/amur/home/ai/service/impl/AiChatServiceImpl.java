package com.amur.home.ai.service.impl;

import com.amur.home.ai.client.DashScopeClient;
import com.amur.home.ai.config.AiServiceConfig;
import com.amur.home.ai.entity.AiChatRequest;
import com.amur.home.ai.entity.AiChatResponse;
import com.amur.home.ai.entity.AiConversation;
import com.amur.home.ai.entity.AiMessage;
import com.amur.home.ai.mapper.AiConversationMapper;
import com.amur.home.ai.mapper.AiMessageMapper;
import com.amur.home.ai.service.AiChatService;
import com.amur.home.ai.util.ContentSafetyFilter;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AiChatServiceImpl implements AiChatService {
    private static final String CONVERSATION_CACHE_KEY = "ai:conversation:";
    private static final int CONTEXT_WINDOW_SIZE = 10;

    @Resource
    private DashScopeClient dashScopeClient;

    @Resource
    private AiServiceConfig config;

    @Resource
    private AiConversationMapper conversationMapper;

    @Resource
    private AiMessageMapper messageMapper;

    @Autowired
    @Qualifier("stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    @Override
    public ServiceResult<AiChatResponse> chat(Long userId, AiChatRequest request) {
        String sanitizedInput = ContentSafetyFilter.sanitizeInput(request.getMessage());
        if (sanitizedInput == null || sanitizedInput.isEmpty()) {
            return ServiceResult.fail("消息不能为空");
        }
        if (ContentSafetyFilter.containsSensitiveInfo(sanitizedInput)) {
            sanitizedInput = ContentSafetyFilter.maskSensitiveInfo(sanitizedInput);
        }
        Long conversationId = request.getConversationId();
        if (conversationId == null) {
            ServiceResult<Long> convResult = createConversation(userId, request.getModuleType(), sanitizedInput.substring(0, Math.min(20, sanitizedInput.length())));
            if (!convResult.isSuccess()) {
                return ServiceResult.fail("创建对话失败");
            }
            conversationId = convResult.getData();
        }
        AiMessage userMsg = new AiMessage();
        userMsg.setConversationId(conversationId);
        userMsg.setSender(1);
        userMsg.setContent(sanitizedInput);
        messageMapper.insert(userMsg);
        String systemPrompt = buildSystemPrompt(request.getModuleType(), request.getSystemPrompt());
        List<Map<String, Object>> messages = new ArrayList<>();
        Map<String, Object> sysMsg = new HashMap<>();
        sysMsg.put("role", "system");
        sysMsg.put("content", systemPrompt);
        messages.add(sysMsg);
        List<AiMessage> history = getRecentMessages(conversationId, CONTEXT_WINDOW_SIZE);
        for (AiMessage msg : history) {
            Map<String, Object> m = new HashMap<>();
            m.put("role", msg.getSender() == 1 ? "user" : "assistant");
            m.put("content", msg.getContent());
            messages.add(m);
        }
        Map<String, Object> currentMsg = new HashMap<>();
        currentMsg.put("role", "user");
        currentMsg.put("content", sanitizedInput);
        messages.add(currentMsg);
        long startTime = System.currentTimeMillis();
        AiChatResponse response = new AiChatResponse();
        try {
            DashScopeClient.ChatResponse apiResponse = dashScopeClient.chat(messages);
            String reply = apiResponse.getChoices().get(0).getMessage().getContent();
            response.setConversationId(conversationId);
            response.setReply(reply);
            response.setModelUsed(config.getModel());
            response.setTokenCount(apiResponse.getUsage().getTotalTokens());
            response.setResponseTimeMs(System.currentTimeMillis() - startTime);
            AiMessage aiMsg = new AiMessage();
            aiMsg.setConversationId(conversationId);
            aiMsg.setSender(2);
            aiMsg.setContent(reply);
            aiMsg.setModelUsed(config.getModel());
            aiMsg.setTokenCount(apiResponse.getUsage().getTotalTokens());
            aiMsg.setResponseTimeMs(response.getResponseTimeMs());
            messageMapper.insert(aiMsg);
            AiConversation conv = conversationMapper.selectById(conversationId);
            if (conv != null) {
                conv.setLastMessage(reply);
                conv.setUpdatedTime(java.time.LocalDateTime.now());
                conversationMapper.updateById(conv);
            }
            String cacheKey = CONVERSATION_CACHE_KEY + conversationId;
            redisTemplate.opsForList().rightPush(cacheKey, reply);
            redisTemplate.expire(cacheKey, 24, TimeUnit.HOURS);
            log.info("AI chat completed: userId={}, conversationId={}, tokens={}, time={}ms",
                    userId, conversationId, response.getTokenCount(), response.getResponseTimeMs());
            return ServiceResult.success(response);
        } catch (Exception e) {
            log.error("AI chat failed: userId={}, conversationId={}, error={}", userId, conversationId, e.getMessage(), e);
            return ServiceResult.fail("AI服务调用失败: " + e.getMessage());
        }
    }

    @Override
    public ServiceResult<List<AiChatResponse>> getConversationHistory(Long conversationId) {
        QueryWrapper<AiMessage> wrapper = new QueryWrapper<>();
        wrapper.eq("conversation_id", conversationId);
        wrapper.orderByAsc("created_time");
        List<AiMessage> messages = messageMapper.selectList(wrapper);
        List<AiChatResponse> history = new ArrayList<>();
        for (AiMessage msg : messages) {
            AiChatResponse r = new AiChatResponse();
            r.setConversationId(conversationId);
            r.setReply(msg.getSender() == 1 ? "[用户]: " + msg.getContent() : msg.getContent());
            r.setModelUsed(msg.getModelUsed());
            r.setTokenCount(msg.getTokenCount());
            r.setResponseTimeMs(msg.getResponseTimeMs());
            history.add(r);
        }
        return ServiceResult.success(history);
    }

    @Override
    public ServiceResult<Long> createConversation(Long userId, String moduleType, String title) {
        AiConversation conversation = new AiConversation();
        conversation.setUserId(userId);
        conversation.setRoleType(1);
        conversation.setSessionId(UUID.randomUUID().toString().replace("-", ""));
        conversation.setModuleType(moduleType != null ? moduleType : "chat");
        conversation.setTitle(title);
        conversation.setCreatedTime(java.time.LocalDateTime.now());
        conversation.setUpdatedTime(java.time.LocalDateTime.now());
        conversation.setDeleted(false);
        conversationMapper.insert(conversation);
        return ServiceResult.success(conversation.getId());
    }

    @Override
    public ServiceResult<Boolean> deleteConversation(Long conversationId) {
        AiConversation conv = conversationMapper.selectById(conversationId);
        if (conv == null) {
            return ServiceResult.fail("对话不存在");
        }
        conv.setDeleted(true);
        conversationMapper.updateById(conv);
        redisTemplate.delete(CONVERSATION_CACHE_KEY + conversationId);
        return ServiceResult.success(true);
    }

    private List<AiMessage> getRecentMessages(Long conversationId, int limit) {
        QueryWrapper<AiMessage> wrapper = new QueryWrapper<>();
        wrapper.eq("conversation_id", conversationId);
        wrapper.orderByDesc("created_time");
        wrapper.last("LIMIT " + limit);
        List<AiMessage> messages = messageMapper.selectList(wrapper);
        Collections.reverse(messages);
        return messages;
    }

    private String buildSystemPrompt(String moduleType, String customPrompt) {
        if (customPrompt != null && !customPrompt.isEmpty()) {
            return customPrompt;
        }
        switch (moduleType) {
            case "homework":
                return "你是一个专业的家庭教育作业辅导助手。你擅长引导学生思考，而不是直接给出答案。请用鼓励性的语言，逐步引导学生理解问题。";
            case "analysis":
                return "你是一个学习分析专家。你擅长分析学生的学习数据，找出薄弱知识点，并提供个性化的学习建议。";
            case "family":
                return "你是一个家庭教育专家。你了解儿童心理学和家庭教育方法，能为家长提供科学的育儿建议。";
            case "chat":
            default:
                return "你是一个温暖、专业的家庭教育智能助手。请根据用户的问题，提供有帮助的回答。";
        }
    }
}
