package com.amur.home.ai.service.impl;

import com.amur.home.ai.client.DashScopeClient;
import com.amur.home.ai.service.AiHomeworkService;
import com.amur.home.ai.util.ContentSafetyFilter;
import com.amur.home.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class AiHomeworkServiceImpl implements AiHomeworkService {
    @Resource
    private DashScopeClient dashScopeClient;

    @Override
    public ServiceResult<String> analyzeHomeworkProblem(Long userId, String problemText, String subject) {
        String sanitized = ContentSafetyFilter.sanitizeInput(problemText);
        List<Map<String, Object>> messages = buildMessages(
                String.format("你是一个%s学科辅导老师。请分析以下题目，指出题目考查的知识点、解题思路。不要直接给出答案。", subject),
                String.format("用户ID=%s的题目：\n%s", userId, sanitized));
        return callAi(messages, "题目分析");
    }

    @Override
    public ServiceResult<String> generateSolutionSteps(Long userId, String problemText, String subject) {
        String sanitized = ContentSafetyFilter.sanitizeInput(problemText);
        List<Map<String, Object>> messages = buildMessages(
                String.format("你是一个%s学科辅导老师。请为以下题目生成逐步解题引导。每步只揭示一个关键点。", subject),
                String.format("用户ID=%s的题目：\n%s", userId, sanitized));
        return callAi(messages, "解题步骤生成");
    }

    @Override
    public ServiceResult<List<Map<String, Object>>> getSimilarExercises(Long userId, String problemText, String subject) {
        String sanitized = ContentSafetyFilter.sanitizeInput(problemText);
        List<Map<String, Object>> messages = buildMessages(
                String.format("你是一个%s学科练习出题专家。请根据以下题目，生成3道难度相当的相似练习题。", subject),
                String.format("用户ID=%s的原题：\n%s", userId, sanitized));
        try {
            DashScopeClient.ChatResponse response = dashScopeClient.chat(messages);
            String reply = response.getChoices().get(0).getMessage().getContent();
            List<Map<String, Object>> exercises = new ArrayList<>();
            Map<String, Object> ex = new HashMap<>();
            ex.put("exercises", reply);
            ex.put("subject", subject);
            exercises.add(ex);
            return ServiceResult.success(exercises);
        } catch (Exception e) {
            log.error("Failed to generate similar exercises: {}", e.getMessage(), e);
            return ServiceResult.fail("相似练习生成失败: " + e.getMessage());
        }
    }

    @Override
    public ServiceResult<List<Map<String, Object>>> analyzeMistakes(Long userId) {
        List<Map<String, Object>> messages = buildMessages(
                "你是一个学习诊断专家。请根据学生的历史错题记录，分析常见错误类型，找出知识薄弱点。输出JSON数组格式。",
                String.format("用户ID=%s的错题分析请求", userId));
        try {
            DashScopeClient.ChatResponse response = dashScopeClient.chat(messages);
            String reply = response.getChoices().get(0).getMessage().getContent();
            List<Map<String, Object>> result = new ArrayList<>();
            Map<String, Object> item = new HashMap<>();
            item.put("analysis", reply);
            item.put("userId", userId);
            result.add(item);
            return ServiceResult.success(result);
        } catch (Exception e) {
            log.error("analyzeMistakes failed: {}", e.getMessage(), e);
            return ServiceResult.fail("错题分析失败: " + e.getMessage());
        }
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
            return ServiceResult.success(reply);
        } catch (Exception e) {
            log.error("{} failed: {}", operation, e.getMessage(), e);
            return ServiceResult.fail(operation + "失败: " + e.getMessage());
        }
    }
}
