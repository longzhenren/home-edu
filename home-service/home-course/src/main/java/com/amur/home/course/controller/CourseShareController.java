package com.amur.home.course.controller;

import com.amur.home.course.entity.CourseShare;
import com.amur.home.course.service.CourseService;
import com.amur.home.util.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Tag(name = "课程分享接口")
@Slf4j
@RestController
@RequestMapping("/share")
public class CourseShareController {
    @Resource
    private CourseService courseService;

    @GetMapping("/join")
    @Operation(summary = "加入课程")
    public ResponseWrapper<?> add(String token, Long userId) {
        if (token == null) {
            return ResponseWrapper.fail("token不能为空");
        }
        if (userId == null) {
            return ResponseWrapper.fail("userId不能为空");
        }
        CourseShare courseShare = courseService.getShareInfo(token);
        if (courseShare == null) {
            return ResponseWrapper.fail("token无效");
        }
        // 判断是否已经加入
        if (courseService.hasJoined(courseShare.getCourseId(), userId)) {
            return ResponseWrapper.fail("已经加入课程");
        }
        return ResponseWrapper.data(courseService.joinCourseByShareToken(userId, token));
    }

    @GetMapping("/info")
    @Operation(summary = "查看邀请信息")
    public ResponseWrapper<CourseShare> info(String token) {
        if (token == null) {
            return ResponseWrapper.fail("token不能为空");
        }
        return ResponseWrapper.data(courseService.getShareInfo(token));
    }

    @GetMapping("/share")
    @Operation(summary = "查看邀请信息")
    public ResponseWrapper<CourseShare> share() {
        if (token == null) {
            return ResponseWrapper.fail("token不能为空");
        }
        return ResponseWrapper.data(courseService.getShareInfo(token));
    }


}
