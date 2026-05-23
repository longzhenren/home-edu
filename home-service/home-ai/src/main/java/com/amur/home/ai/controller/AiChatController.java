package com.amur.home.ai.controller;

import com.amur.home.ai.entity.AiChatRequest;
import com.amur.home.ai.entity.AiChatResponse;
import com.amur.home.ai.service.AiChatService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "AI智能对话")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/ai/chat")
public class AiChatController {
    private final AiChatService aiChatService;

    @Operation(summary = "AI对话")
    @PostMapping("/send")
    public ResponseWrapper<AiChatResponse> send(@RequestParam Long userId, @RequestBody AiChatRequest request) {
        request.setConversationId(request.getConversationId());
        ServiceResult<AiChatResponse> res = aiChatService.chat(userId, request);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "获取对话历史")
    @GetMapping("/history")
    public ResponseWrapper<List<AiChatResponse>> history(@RequestParam Long conversationId) {
        ServiceResult<List<AiChatResponse>> res = aiChatService.getConversationHistory(conversationId);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "创建新对话")
    @PostMapping("/create")
    public ResponseWrapper<Long> create(@RequestParam Long userId,
                                        @RequestParam(required = false, defaultValue = "chat") String moduleType,
                                        @RequestParam String title) {
        ServiceResult<Long> res = aiChatService.createConversation(userId, moduleType, title);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "删除对话")
    @PostMapping("/delete")
    public ResponseWrapper<Boolean> delete(@RequestParam Long conversationId) {
        ServiceResult<Boolean> res = aiChatService.deleteConversation(conversationId);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }
}
