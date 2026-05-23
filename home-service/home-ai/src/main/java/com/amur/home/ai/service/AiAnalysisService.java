package com.amur.home.ai.service;

import com.amur.home.ai.entity.AiLearningReport;
import com.amur.home.util.ServiceResult;
import java.util.Map;
import java.util.List;

public interface AiAnalysisService {
    ServiceResult<AiLearningReport> generateLearningReport(Long userId, String reportType);
    ServiceResult<List<AiLearningReport>> getLearningReports(Long userId);
    ServiceResult<List<Map<String, Object>>> analyzeKnowledgeWeakness(Long userId);
    ServiceResult<List<Map<String, Object>>> getLearningRecommendations(Long userId);
}
