package com.amur.home.ai.controller;

import com.amur.home.ai.entity.AiLearningReport;
import com.amur.home.ai.service.AiAnalysisService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "AI学习分析")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/ai/analysis")
public class AiAnalysisController {
    private final AiAnalysisService aiAnalysisService;

    @Operation(summary = "生成学习报告")
    @PostMapping("/report")
    public ResponseWrapper<AiLearningReport> generateReport(@RequestParam Long userId,
                                                            @RequestParam(defaultValue = "weekly") String reportType) {
        ServiceResult<AiLearningReport> res = aiAnalysisService.generateLearningReport(userId, reportType);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "获取学习报告列表")
    @GetMapping("/reports")
    public ResponseWrapper<List<AiLearningReport>> getReports(@RequestParam Long userId) {
        ServiceResult<List<AiLearningReport>> res = aiAnalysisService.getLearningReports(userId);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "分析知识薄弱点")
    @GetMapping("/weakness")
    public ResponseWrapper<List<Map<String, Object>>> analyzeWeakness(@RequestParam Long userId) {
        ServiceResult<List<Map<String, Object>>> res = aiAnalysisService.analyzeKnowledgeWeakness(userId);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "获取学习推荐")
    @GetMapping("/recommendations")
    public ResponseWrapper<List<Map<String, Object>>> getRecommendations(@RequestParam Long userId) {
        ServiceResult<List<Map<String, Object>>> res = aiAnalysisService.getLearningRecommendations(userId);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }
}
