package com.amur.home.ai.service.impl;

import com.amur.home.ai.client.DashScopeClient;
import com.amur.home.ai.service.AiFamilyService;
import com.amur.home.ai.util.ContentSafetyFilter;
import com.amur.home.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class AiFamilyServiceImpl implements AiFamilyService {
    @Resource
    private DashScopeClient dashScopeClient;

    @Override
    public ServiceResult<String> getFamilyEducationAdvice(Long userId, String scenario) {
        String sanitized = ContentSafetyFilter.sanitizeInput(scenario);
        List<Map<String, Object>> messages = buildMessages(
                "你是一个资深家庭教育顾问，精通儿童心理学和教育学。请根据家长描述的情况，给出科学、实用的家庭教育建议。",
                String.format("用户ID=%s的家长咨询：%s", userId, sanitized));
        return callAi(messages, "家庭教育建议");
    }

    @Override
    public ServiceResult<String> generateFamilyPlan(Long userId, String requirements) {
        String sanitized = ContentSafetyFilter.sanitizeInput(requirements);
        List<Map<String, Object>> messages = buildMessages(
                "你是一个家庭教育规划师。请根据家长的需求，制定一份详细的家庭学习计划。",
                String.format("用户ID=%s的家庭计划需求：%s", userId, sanitized));
        return callAi(messages, "家庭计划生成");
    }

    @Override
    public ServiceResult<String> suggestParentChildActivity(Long userId, int childAge) {
        List<Map<String, Object>> messages = buildMessages(
                "你是一个亲子活动推荐专家。请根据孩子的年龄，推荐适合的亲子活动。",
                String.format("用户ID=%s，孩子年龄=%d岁，请推荐适合的亲子活动", userId, childAge));
        return callAi(messages, "亲子活动推荐");
    }

    @Override
    public ServiceResult<String> analyzeCommunicationStyle(Long userId, String context) {
        String sanitized = ContentSafetyFilter.sanitizeInput(context);
        List<Map<String, Object>> messages = buildMessages(
                "你是一个家庭沟通分析专家。请分析家长描述的家庭沟通情况，识别沟通模式中的问题，并提供改善建议。",
                String.format("用户ID=%s的家庭沟通情况：%s", userId, sanitized));
        return callAi(messages, "沟通风格分析");
    }

    private List<Map<String, Object>> buildMessages(String systemPrompt, String userContent) {
        List<Map<String, Object>> messages = new ArrayList<>();
        Map<String, Object> sys = new HashMap<>();
        sys.put("role", "system");
        sys.put("content", systemPrompt);
        messages.add(sys);
        Map<String, Object> user = new HashMap<>();
        user.put("role", "user");
        user.put("content", userContent);
        messages.add(user);
        return messages;
    }

    private ServiceResult<String> callAi(List<Map<String, Object>> messages, String operation) {
        try {
            DashScopeClient.ChatResponse response = dashScopeClient.chat(messages);
            String reply = response.getChoices().get(0).getMessage().getContent();
            log.info("{} completed: tokens={}", operation, response.getUsage().getTotalTokens());
            return ServiceResult.success(reply);
        } catch (Exception e) {
            log.error("{} failed: {}", operation, e.getMessage(), e);
            return ServiceResult.fail(operation + "失败: " + e.getMessage());
        }
    }
}
