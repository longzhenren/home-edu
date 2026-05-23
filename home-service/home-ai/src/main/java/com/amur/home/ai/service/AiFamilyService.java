package com.amur.home.ai.service;

import com.amur.home.util.ServiceResult;

public interface AiFamilyService {
    ServiceResult<String> getFamilyEducationAdvice(Long userId, String scenario);
    ServiceResult<String> generateFamilyPlan(Long userId, String requirements);
    ServiceResult<String> suggestParentChildActivity(Long userId, int childAge);
    ServiceResult<String> analyzeCommunicationStyle(Long userId, String context);
}
