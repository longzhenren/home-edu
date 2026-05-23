package com.amur.home.ai.service;

import com.amur.home.util.ServiceResult;
import java.util.Map;
import java.util.List;

public interface AiHomeworkService {
    ServiceResult<String> analyzeHomeworkProblem(Long userId, String problemText, String subject);
    ServiceResult<String> generateSolutionSteps(Long userId, String problemText, String subject);
    ServiceResult<List<Map<String, Object>>> getSimilarExercises(Long userId, String problemText, String subject);
    ServiceResult<List<Map<String, Object>>> analyzeMistakes(Long userId);
}
