package com.amur.home.course.controller;

import com.amur.home.course.service.CourseWareService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;


@Tag(name = "课程资料接口")
@Slf4j
@RestController
@RequestMapping("/courseware")
public class CourseWareController {
    @Autowired
    CourseWareService courseWareService;

    @PostMapping("/upload")
    @Operation(summary = "上传课件")
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        String url = courseWareService.upload(file);
        return ResponseEntity.created(new URI(url)).build();
    }

    @GetMapping("/{fileName}")
    @Operation(summary = "下载课件")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws Exception {
        Resource resource = courseWareService.download(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"").body(resource);
    }

    @GetMapping("/{fileName}/preview")
    @Operation(summary = "预览课件")
    public ResponseEntity<Resource> previewFile(@PathVariable String fileName) throws Exception {
        Resource resource = courseWareService.preview(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileName + "\"").body(resource);
    }
}
