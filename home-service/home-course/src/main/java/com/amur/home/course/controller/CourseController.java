package com.amur.home.course.controller;

import com.amur.home.util.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "课程信息模块")
@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {
    @PostMapping("/add")
    @Operation(summary = "添加课程")
    public ResponseWrapper<?> add() {
        return null;
    }

    @PostMapping("/del")
    @Operation(summary = "删除课程")
    public ResponseWrapper<?> del() {
        return null;
    }

    @PostMapping("/mod")
    @Operation(summary = "修改课程")
    public ResponseWrapper<?> mod() {
        return null;
    }

    @PostMapping("/rank")
    @Operation(summary = "课程评分")
    public ResponseWrapper<?> rank() {
        return null;
    }

    @PostMapping("/comment")
    @Operation(summary = "课程评价")
    public ResponseWrapper<?> comment() {
        return null;
    }

    @PostMapping("/share")
    @Operation(summary = "课程分享链接生成")
    public ResponseWrapper<?> share() {
        return null;
    }

    @PostMapping("/mod_access")
    @Operation(summary = "课程权限修改")
    public ResponseWrapper<?> modAccess() {
        return null;
    }

    @PostMapping("/add_stu")
    @Operation(summary = "添加学生")
    public ResponseWrapper<?> addStudent() {
        return null;
    }

    @PostMapping("/del_stu")
    @Operation(summary = "删除学生")
    public ResponseWrapper<?> delStudent() {
        return null;
    }

    @PostMapping("/create_list")
    @Operation(summary = "创建课程集合")
    public ResponseWrapper<?> createList() {
        return null;
    }
    @PostMapping("/del_list")
    @Operation(summary = "删除课程集合")
    public ResponseWrapper<?> deleteList() {
        return null;
    }

    @PostMapping("/list_add")
    @Operation(summary = "添加到课程集合")
    public ResponseWrapper<?> listAdd() {
        return null;
    }

}
