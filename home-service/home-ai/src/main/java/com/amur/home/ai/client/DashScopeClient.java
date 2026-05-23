package com.amur.home.ai.client;

import com.amur.home.ai.config.AiServiceConfig;
import com.amur.home.ai.util.CredentialEncryptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class DashScopeClient {
    @Resource
    private AiServiceConfig config;

    private OkHttpClient httpClient;
    private ObjectMapper objectMapper;
    private String resolvedApiKey;

    @PostConstruct
    public void init() throws Exception {
        httpClient = new OkHttpClient.Builder()
                .connectTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
                .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
                .build();
        objectMapper = new ObjectMapper();
        loadApiKey();
    }

    private void loadApiKey() throws Exception {
        String envKey = System.getenv("DASHSCOPE_API_KEY");
        if (envKey != null && !envKey.isEmpty()) {
            resolvedApiKey = envKey;
        } else if (config.getEncryptedKey() != null && config.getDecryptionKey() != null) {
            resolvedApiKey = CredentialEncryptor.decrypt(config.getEncryptedKey(), config.getDecryptionKey());
        } else if (config.getApiKey() != null) {
            resolvedApiKey = config.getApiKey();
        } else {
            throw new IllegalStateException("DashScope API key not configured.");
        }
        log.info("DashScope API key loaded successfully");
    }

    public ChatResponse chat(List<Map<String, Object>> messages) throws IOException {
        Map<String, Object> body = new HashMap<>();
        body.put("model", config.getModel());
        body.put("messages", messages);
        body.put("max_tokens", config.getMaxTokens());
        body.put("temperature", config.getTemperature());

        RequestBody requestBody = RequestBody.create(
                objectMapper.writeValueAsString(body),
                MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(config.getBaseUrl())
                .header("Authorization", "Bearer " + resolvedApiKey)
                .header("Content-Type", "application/json")
                .post(requestBody)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("DashScope API error: " + response.code() + " " + response.message());
            }
            String responseBody = response.body() != null ? response.body().string() : "";
            return objectMapper.readValue(responseBody, ChatResponse.class);
        }
    }

    public static class ChatResponse {
        private List<Choice> choices;
        private Usage usage;
        private String id;
        private String object;

        public List<Choice> getChoices() { return choices; }
        public void setChoices(List<Choice> choices) { this.choices = choices; }
        public Usage getUsage() { return usage; }
        public void setUsage(Usage usage) { this.usage = usage; }
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getObject() { return object; }
        public void setObject(String object) { this.object = object; }

        public static class Choice {
            private Message message;
            private String finishReason;
            private int index;

            public Message getMessage() { return message; }
            public void setMessage(Message message) { this.message = message; }
            public String getFinishReason() { return finishReason; }
            public void setFinishReason(String finishReason) { this.finishReason = finishReason; }
            public int getIndex() { return index; }
            public void setIndex(int index) { this.index = index; }

            public static class Message {
                private String role;
                private String content;

                public String getRole() { return role; }
                public void setRole(String role) { this.role = role; }
                public String getContent() { return content; }
                public void setContent(String content) { this.content = content; }
            }
        }

        public static class Usage {
            private int promptTokens;
            private int completionTokens;
            private int totalTokens;

            public int getPromptTokens() { return promptTokens; }
            public void setPromptTokens(int promptTokens) { this.promptTokens = promptTokens; }
            public int getCompletionTokens() { return completionTokens; }
            public void setCompletionTokens(int completionTokens) { this.completionTokens = completionTokens; }
            public int getTotalTokens() { return totalTokens; }
            public void setTotalTokens(int totalTokens) { this.totalTokens = totalTokens; }
        }
    }
}
