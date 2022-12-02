package com.amur.home.course.controller;

import com.amur.home.course.entity.CourseWare;
import com.amur.home.course.service.CourseFavService;
import com.amur.home.course.service.CourseWareService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Tag(name = "课程资料接口")
@Slf4j
@RestController
@RequestMapping("/courseware")
public class CourseWareController {
    @Autowired
    private CourseWareService courseWareService;

    @Autowired
    private CourseFavService courseFavService;

    @PostMapping("/upload")
    @Async
    @Operation(summary = "上传课件")
    @Parameters({@Parameter(name = "file", in = ParameterIn.QUERY, required = true, description = "课件文件")})
    public CompletableFuture<ResponseEntity<ResponseWrapper<String>>> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        ServiceResult<String> res = courseWareService.upload(file);
        if (res.isSuccess()) {
            return CompletableFuture.completedFuture(ResponseEntity.ok(ResponseWrapper.data(res.getData())));
        } else {
            return CompletableFuture.completedFuture(ResponseEntity.ok(ResponseWrapper.fail(res.getMessage())));
        }
    }

    @GetMapping("/{fileName}")
    @Operation(summary = "下载课件")
    @Parameters({@Parameter(name = "fileName", in = ParameterIn.QUERY, required = true, description = "返回的课件文件名")})
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws Exception {
        Resource resource = courseWareService.download(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"").body(resource);
    }

    @GetMapping("/{fileName}/preview")
    @Operation(summary = "预览课件")
    @Parameters({@Parameter(name = "fileName", in = ParameterIn.QUERY, required = true, description = "返回的课件文件名")})
    public ResponseEntity<Resource> previewFile(@PathVariable String fileName) throws Exception {
        Resource resource = courseWareService.preview(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileName + "\"").body(resource);
    }

    @GetMapping("/fav/list")
    @Operation(summary = "查看收藏课程")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<List<Long>> courseWareFavList(Long userId) {
        ServiceResult<List<Long>> res = courseFavService.courseWareFavList(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/fav/list/info")
    @Operation(summary = "查看收藏课件详情")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<List<CourseWare>> courseWareFavListInfo(Long userId) {
        ServiceResult<List<CourseWare>> res = courseFavService.courseWareFavListInfo(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/fav/add")
    @Operation(summary = "添加收藏课件")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "courseWareId", in = ParameterIn.QUERY, required = true, description = "课件ID")})
    public ResponseWrapper<Void> courseWareFavAdd(Long userId, Long courseWareId) {
        ServiceResult<Void> res = courseFavService.courseWareFavAdd(userId, courseWareId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }


    @PostMapping("/fav/cancel")
    @Operation(summary = "取消收藏课件")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "courseWareId", in = ParameterIn.QUERY, required = true, description = "课件ID")})
    public ResponseWrapper<Void> courseWareFavDel(Long userId, Long courseWareId) {
        ServiceResult<Void> res = courseFavService.courseWareFavDel(userId, courseWareId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/add")
    @Operation(summary = "添加课件")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "courseWareName", in = ParameterIn.QUERY, required = true, description = "课件名称"), @Parameter(name = "courseWareUrl", in = ParameterIn.QUERY, required = true, description = "课件地址")})
    public ResponseWrapper<Void> courseWareAdd(Long courseId, String courseWareName, String courseWareUrl, String description) {
        ServiceResult<Void> res = courseWareService.courseWareAdd(courseId, courseWareName, courseWareUrl, description);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/del")
    @Operation(summary = "删除课件")
    @Parameters({@Parameter(name = "courseWareId", in = ParameterIn.QUERY, required = true, description = "课件ID")})
    public ResponseWrapper<Void> courseWareDel(String courseWareId) {
        ServiceResult<Void> res = courseWareService.courseWareDel(courseWareId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/rename")
    @Operation(summary = "重命名课件")
    @Parameters({@Parameter(name = "courseWareId", in = ParameterIn.QUERY, required = true, description = "课件ID"), @Parameter(name = "courseWareName", in = ParameterIn.QUERY, required = true, description = "课件名称")})
    public ResponseWrapper<Void> courseWareRename(String courseWareId, String courseWareName) {
        ServiceResult<Void> res = courseWareService.courseWareRename(courseWareId, courseWareName);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/desc")
    @Operation(summary = "修改课件备注")
    @Parameters({@Parameter(name = "courseWareId", in = ParameterIn.QUERY, required = true, description = "课件ID"), @Parameter(name = "courseWareName", in = ParameterIn.QUERY, required = true, description = "课件名称")})
    public ResponseWrapper<Void> courseWareReDesc(String courseWareId, String description) {
        ServiceResult<Void> res = courseWareService.courseWareReDesc(courseWareId, description);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/list")
    @Operation(summary = "查看课件列表")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<List<CourseWare>> courseWareList(Long courseId) {
        ServiceResult<List<CourseWare>> res = courseWareService.courseWareList(courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }
}
