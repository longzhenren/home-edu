package com.amur.home.ai.controller;

import com.amur.home.ai.service.AiHomeworkService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "AI作业辅导")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/ai/homework")
public class AiHomeworkController {
    private final AiHomeworkService aiHomeworkService;

    @Operation(summary = "分析作业题目")
    @PostMapping("/analyze")
    public ResponseWrapper<String> analyze(@RequestParam Long userId,
                                           @RequestParam String problemText,
                                           @RequestParam(defaultValue = "数学") String subject) {
        ServiceResult<String> res = aiHomeworkService.analyzeHomeworkProblem(userId, problemText, subject);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "生成解题步骤")
    @PostMapping("/steps")
    public ResponseWrapper<String> steps(@RequestParam Long userId,
                                         @RequestParam String problemText,
                                         @RequestParam(defaultValue = "数学") String subject) {
        ServiceResult<String> res = aiHomeworkService.generateSolutionSteps(userId, problemText, subject);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "获取相似练习")
    @PostMapping("/similar")
    public ResponseWrapper<List<Map<String, Object>>> similar(@RequestParam Long userId,
                                                              @RequestParam String problemText,
                                                              @RequestParam(defaultValue = "数学") String subject) {
        ServiceResult<List<Map<String, Object>>> res = aiHomeworkService.getSimilarExercises(userId, problemText, subject);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "分析错题")
    @GetMapping("/mistakes")
    public ResponseWrapper<List<Map<String, Object>>> mistakes(@RequestParam Long userId) {
        ServiceResult<List<Map<String, Object>>> res = aiHomeworkService.analyzeMistakes(userId);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }
}
