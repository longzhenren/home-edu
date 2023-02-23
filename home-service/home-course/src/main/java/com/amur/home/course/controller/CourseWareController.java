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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;


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
    @Operation(summary = "查看收藏课程详情")
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
    @Operation(summary = "添加收藏课程")
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
    @Operation(summary = "取消收藏课程")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID"), @Parameter(name = "courseWareId", in = ParameterIn.QUERY, required = true, description = "课件ID")})
    public ResponseWrapper<Void> courseWareFavDel(Long userId, Long courseWareId) {
        ServiceResult<Void> res = courseFavService.courseWareFavDel(userId, courseWareId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }
}
