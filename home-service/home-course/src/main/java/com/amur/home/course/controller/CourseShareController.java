package com.amur.home.course.controller;

import com.amur.home.common.Constants;
import com.amur.home.course.service.CourseService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Tag(name = "课程分享接口")
@Slf4j
@RestController
@RequestMapping("/share")
public class CourseShareController {
    @Resource
    private CourseService courseService;

    @GetMapping("/join")
    @Operation(summary = "加入课程")
    @Parameters({@Parameter(name = "token", in = ParameterIn.QUERY, required = true, description = "课程分享token"), @Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<?> add(@NotBlank(message = "token不能为空") String token, @NotBlank(message = "userId不能为空") Long userId) {
        ServiceResult<?> res = courseService.joinByToken(token, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/token")
    @Operation(summary = "课程分享链接生成")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID"), @Parameter(name = "inviterId", in = ParameterIn.QUERY, required = true, description = "邀请人ID"), @Parameter(name = "as", in = ParameterIn.QUERY, required = true, description = "邀请身份"), @Parameter(name = "expireTime", in = ParameterIn.QUERY, required = true, description = "过期时间")})
    public ResponseWrapper<?> share(Long courseId, Long inviterId, Constants.InviteAs as, Date expireTime) {
        ServiceResult<?> res = courseService.share(courseId, inviterId, as, expireTime);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/info")
    @Operation(summary = "根据Token查看课程分享链接")
    @Parameters({@Parameter(name = "shareToken", in = ParameterIn.QUERY, required = true, description = "分享token")})
    public ResponseWrapper<?> shareInfoByUserId(String shareToken) {
        ServiceResult<?> res = courseService.shareInfo(shareToken);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/info/user")
    @Operation(summary = "根据用户id查看课程分享链接")
    @Parameters({@Parameter(name = "userId", in = ParameterIn.QUERY, required = true, description = "用户ID")})
    public ResponseWrapper<?> shareInfoByUserId(Long userId) {
        ServiceResult<?> res = courseService.shareInfoByUserId(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @GetMapping("/info/id")
    @Operation(summary = "根据课程id查看课程分享链接")
    @Parameters({@Parameter(name = "courseId", in = ParameterIn.QUERY, required = true, description = "课程ID")})
    public ResponseWrapper<?> shareInfoById(Long courseId) {
        ServiceResult<?> res = courseService.shareInfoById(courseId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @PostMapping("/cancel")
    @Operation(summary = "取消分享链接")
    @Parameters({@Parameter(name = "shareId", in = ParameterIn.QUERY, required = true, description = "分享ID")})
    public ResponseWrapper<?> shareCancel(String shareToken) {
        ServiceResult<?> res = courseService.shareCancel(shareToken);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }
}
