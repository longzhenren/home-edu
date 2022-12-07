package com.amur.home.course.controller;

import com.amur.home.course.service.CourseService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Tag(name = "课程信息接口")
@Slf4j
@RestController
@RequestMapping("/course")
public class CourseCommentController {
    @Resource
    private CourseService courseService;

    @PostMapping("/comment/add")
    @Operation(summary = "添加课程评价")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "comment", in = ParameterIn.QUERY, required = true, description = "评价")})
    public ResponseWrapper<?> commentAdd(Long courseId, Long userId, String comment, Double score) {
        ServiceResult<?> res = courseService.commentAdd(courseId, userId, comment, score);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/comment/del")
    @Operation(summary = "删除课程评价")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<?> commentDel(Long courseId, Long userId) {
        ServiceResult<?> res = courseService.commentDel(courseId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/comment/list")
    @Operation(summary = "列出课程评价")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<?> commentInfoList(Long courseId) {
        ServiceResult<?> res = courseService.commentInfoList(courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/comment/search")
    @Operation(summary = "搜索课程评价")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "keyword", in = ParameterIn.QUERY, required = true, description = "关键字")})
    public ResponseWrapper<?> commentInfoList(Long courseId, String keyword) {
        ServiceResult<?> res = courseService.commentInfoList(courseId, keyword);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/comment/user")
    @Operation(summary = "查看用户给出的课程评价")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<?> commentInfoByUserId(Long userId) {
        ServiceResult<?> res = courseService.commentInfoByUserId(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }
}
