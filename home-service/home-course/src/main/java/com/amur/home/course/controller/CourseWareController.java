package com.amur.home.course.controller;

import com.amur.home.util.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "课程资料接口")
@Slf4j
@RestController
@RequestMapping("/courseware")
public class CourseWareController {
    @PostMapping("/upload")
    @Operation(summary = "上传课件")
    public ResponseWrapper<?> upload() {
        return null;
    }

    @PostMapping("/get")
    @Operation(summary = "下载课件")
    public ResponseWrapper<?> download() {
        return null;
    }

    @PostMapping("/del")
    @Operation(summary = "删除课件")
    public ResponseWrapper<?> del() {
        return null;
    }

    @PostMapping("/preview")
    @Operation(summary = "预览课件")
    public ResponseWrapper<?> preview() {
        return null;
    }

}
