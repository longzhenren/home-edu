package com.amur.home.ai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "ai.service")
public class AiServiceConfig {
    private String provider = "dashscope";
    private String baseUrl = "https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions";
    private String model = "qwen-plus";
    private String apiKey;
    private String encryptedKey;
    private String decryptionKey;
    private int maxTokens = 2048;
    private double temperature = 0.7;
    private int timeout = 30000;
    private boolean streamEnabled = false;
}
