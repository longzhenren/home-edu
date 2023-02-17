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

    @PostMapping("/comment/add")
    @Operation(summary = "添加课程评价")
    public ResponseWrapper<?> commentAdd() {
        return null;
    }

    @PostMapping("/comment/del")
    @Operation(summary = "删除课程评价")
    public ResponseWrapper<?> commentDel() {
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

    @PostMapping("/stu/add")
    @Operation(summary = "添加学生")
    public ResponseWrapper<?> addStudent() {
        return null;
    }

    @PostMapping("/stu/del")
    @Operation(summary = "删除学生")
    public ResponseWrapper<?> delStudent() {
        return null;
    }

    @PostMapping("/stu/list")
    @Operation(summary = "学生列表")
    public ResponseWrapper<?> listStudent() {
        return null;
    }

    @PostMapping("/list/create")
    @Operation(summary = "创建课程集合")
    public ResponseWrapper<?> createList() {
        return null;
    }

    @PostMapping("/list/show")
    @Operation(summary = "查看课程集合")
    public ResponseWrapper<?> showList() {
        return null;
    }

    @PostMapping("/list/del")
    @Operation(summary = "删除课程集合")
    public ResponseWrapper<?> deleteList() {
        return null;
    }

    @PostMapping("/list/add")
    @Operation(summary = "添加到课程集合")
    public ResponseWrapper<?> listAdd() {
        return null;
    }

    @PostMapping("/list/rm")
    @Operation(summary = "从课程集合删除")
    public ResponseWrapper<?> listRemove() {
        return null;
    }

    @PostMapping("/list/mod")
    @Operation(summary = "修改课程集合信息")
    public ResponseWrapper<?> listMod() {
        return null;
    }

    @PostMapping("/fav/add")
    @Operation(summary = "收藏课程")
    public ResponseWrapper<?> favAdd() {
        return null;
    }

    @PostMapping("/fav/rm")
    @Operation(summary = "取消收藏课程")
    public ResponseWrapper<?> favRemove() {
        return null;
    }

    @PostMapping("/fav/add_list")
    @Operation(summary = "收藏列表")
    public ResponseWrapper<?> favAddList() {
        return null;
    }

    @PostMapping("/like/add")
    @Operation(summary = "点赞课程")
    public ResponseWrapper<?> likeAdd() {
        return null;
    }

    @PostMapping("/like/del")
    @Operation(summary = "取消点赞课程")
    public ResponseWrapper<?> likeDel() {
        return null;
    }

}
