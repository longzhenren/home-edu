package com.amur.home.course.controller;

import com.amur.home.common.Constants;
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
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Tag(name = "课程分享接口")
@Slf4j
@RestController
@RequestMapping("/share")
public class CourseShareController {
    @Resource
    private CourseService courseService;

    @GetMapping("/join")
    @Operation(summary = "加入课程")
    public ResponseWrapper<?> add(@NotBlank(message = "token不能为空") String token, @NotBlank(message = "userId不能为空") Long userId) {
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
    public ResponseWrapper<CourseShare> info(@NotBlank(message = "token不能为空") String token) {
        CourseShare courseShare = courseService.getShareInfo(token);
        if (courseShare == null) {
            return ResponseWrapper.fail("token无效");
        }
        return ResponseWrapper.data(courseShare);
    }

    @GetMapping("/list")
    @Operation(summary = "查看发出的邀请")
    public ResponseWrapper<List<CourseShare>> list(@NotBlank(message = "userId不能为空") Long userId) {
        return ResponseWrapper.data(courseService.listShareInfoByUserId(userId));
    }

    @GetMapping("/share")
    @Operation(summary = "发送课程邀请")
    public ResponseWrapper<String> share(@NotBlank(message = "courseId不能为空") Long courseId, @NotBlank(message = "userId不能为空") Long userId, @NotBlank(message = "expireTime不能为空") Date expireTime, Constants.InviteAs inviteAs) {
        return ResponseWrapper.data(courseService.generateShareToken(courseId, userId, expireTime, inviteAs));
    }

    @GetMapping("/cancel")
    @Operation(summary = "取消发出的邀请")
    public ResponseWrapper<?> cancel(@NotBlank(message = "token不能为空") String token, @NotBlank(message = "userId不能为空") Long userId) {
        if (courseService.getShareInfo(token) == null) return ResponseWrapper.fail("token无效");
        return ResponseWrapper.data(courseService.cancelShareToken(token, userId));
    }

}
