package com.amur.home.ai.controller;

import com.amur.home.ai.service.AiFamilyService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "AI家庭教育")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/ai/family")
public class AiFamilyController {
    private final AiFamilyService aiFamilyService;

    @Operation(summary = "获取家庭教育建议")
    @PostMapping("/advice")
    public ResponseWrapper<String> getAdvice(@RequestParam Long userId, @RequestParam String scenario) {
        ServiceResult<String> res = aiFamilyService.getFamilyEducationAdvice(userId, scenario);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "生成家庭学习计划")
    @PostMapping("/plan")
    public ResponseWrapper<String> generatePlan(@RequestParam Long userId, @RequestParam String requirements) {
        ServiceResult<String> res = aiFamilyService.generateFamilyPlan(userId, requirements);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "推荐亲子活动")
    @GetMapping("/activity")
    public ResponseWrapper<String> suggestActivity(@RequestParam Long userId, @RequestParam int childAge) {
        ServiceResult<String> res = aiFamilyService.suggestParentChildActivity(userId, childAge);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }

    @Operation(summary = "分析家庭沟通风格")
    @PostMapping("/communication")
    public ResponseWrapper<String> analyzeCommunication(@RequestParam Long userId, @RequestParam String context) {
        ServiceResult<String> res = aiFamilyService.analyzeCommunicationStyle(userId, context);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        }
        return ResponseWrapper.data(res.getData());
    }
}
