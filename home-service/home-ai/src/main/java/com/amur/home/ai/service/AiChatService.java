package com.amur.home.ai.service;

import com.amur.home.ai.entity.AiChatRequest;
import com.amur.home.ai.entity.AiChatResponse;
import com.amur.home.util.ServiceResult;
import java.util.List;

public interface AiChatService {
    ServiceResult<AiChatResponse> chat(Long userId, AiChatRequest request);
    ServiceResult<List<AiChatResponse>> getConversationHistory(Long conversationId);
    ServiceResult<Long> createConversation(Long userId, String moduleType, String title);
    ServiceResult<Boolean> deleteConversation(Long conversationId);
}
