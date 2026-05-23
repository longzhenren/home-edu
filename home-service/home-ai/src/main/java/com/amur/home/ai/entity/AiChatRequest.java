package com.amur.home.ai.entity;

import lombok.Data;

@Data
public class AiChatRequest {
    private Long conversationId;
    private String message;
    private String moduleType;
    private String systemPrompt;
}
