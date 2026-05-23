package com.amur.home.ai.service.impl;

import com.amur.home.ai.client.DashScopeClient;
import com.amur.home.ai.config.AiServiceConfig;
import com.amur.home.ai.entity.AiLearningReport;
import com.amur.home.ai.mapper.AiLearningReportMapper;
import com.amur.home.ai.service.AiAnalysisService;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class AiAnalysisServiceImpl implements AiAnalysisService {
    @Resource
    private DashScopeClient dashScopeClient;

    @Resource
    private AiServiceConfig config;

    @Resource
    private AiLearningReportMapper reportMapper;

    @Override
    public ServiceResult<AiLearningReport> generateLearningReport(Long userId, String reportType) {
        String prompt = String.format("请为用户ID=%s生成%s类型的学习分析报告。分析维度包括：知识点掌握情况、学习进度趋势、薄弱环节识别、个性化学习建议。", userId, reportType);
        List<Map<String, Object>> messages = new ArrayList<>();
        Map<String, Object> sysMsg = new HashMap<>();
        sysMsg.put("role", "system");
        sysMsg.put("content", "你是一个学习分析专家。请分析学生的学习数据，找出薄弱知识点，并提供个性化学习建议。");
        messages.add(sysMsg);
        Map<String, Object> userMsg = new HashMap<>();
        userMsg.put("role", "user");
        userMsg.put("content", prompt);
        messages.add(userMsg);
        try {
            DashScopeClient.ChatResponse response = dashScopeClient.chat(messages);
            String reply = response.getChoices().get(0).getMessage().getContent();
            AiLearningReport report = new AiLearningReport();
            report.setUserId(userId);
            report.setReportType(reportType);
            report.setKnowledgeWeakness(reply);
            report.setLearningTrend("{}");
            report.setRecommendations(reply);
            report.setGeneratedTime(LocalDateTime.now());
            report.setDeleted(false);
            reportMapper.insert(report);
            log.info("Learning report generated: userId={}, type={}, tokens={}", userId, reportType, response.getUsage().getTotalTokens());
            return ServiceResult.success(report);
        } catch (Exception e) {
            log.error("Failed to generate learning report: userId={}, error={}", userId, e.getMessage(), e);
            return ServiceResult.fail("学习报告生成失败: " + e.getMessage());
        }
    }

    @Override
    public ServiceResult<List<AiLearningReport>> getLearningReports(Long userId) {
        QueryWrapper<AiLearningReport> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.orderByDesc("generated_time");
        List<AiLearningReport> reports = reportMapper.selectList(wrapper);
        return ServiceResult.success(reports);
    }

    @Override
    public ServiceResult<List<Map<String, Object>>> analyzeKnowledgeWeakness(Long userId) {
        List<Map<String, Object>> weaknesses = new ArrayList<>();
        QueryWrapper<AiLearningReport> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.orderByDesc("generated_time");
        wrapper.last("LIMIT 1");
        AiLearningReport latest = reportMapper.selectOne(wrapper);
        if (latest != null && latest.getKnowledgeWeakness() != null) {
            Map<String, Object> w = new HashMap<>();
            w.put("weakness", latest.getKnowledgeWeakness());
            w.put("generatedAt", latest.getGeneratedTime());
            weaknesses.add(w);
        }
        return ServiceResult.success(weaknesses);
    }

    @Override
    public ServiceResult<List<Map<String, Object>>> getLearningRecommendations(Long userId) {
        List<Map<String, Object>> recommendations = new ArrayList<>();
        QueryWrapper<AiLearningReport> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.orderByDesc("generated_time");
        wrapper.last("LIMIT 3");
        List<AiLearningReport> reports = reportMapper.selectList(wrapper);
        for (AiLearningReport report : reports) {
            if (report.getRecommendations() != null) {
                Map<String, Object> r = new HashMap<>();
                r.put("recommendation", report.getRecommendations());
                r.put("type", report.getReportType());
                r.put("generatedAt", report.getGeneratedTime());
                recommendations.add(r);
            }
        }
        return ServiceResult.success(recommendations);
    }
}
