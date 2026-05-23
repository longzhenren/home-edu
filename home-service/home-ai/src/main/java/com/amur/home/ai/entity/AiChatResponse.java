package com.amur.home.ai.entity;

import lombok.Data;

@Data
public class AiChatResponse {
    private Long conversationId;
    private String reply;
    private String modelUsed;
    private int tokenCount;
    private long responseTimeMs;
}
