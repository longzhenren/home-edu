package com.amur.home.user.controller;

import com.amur.home.common.Constants;
import com.amur.home.dto.PageResult;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.service.UserService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Tag(name = "用户模块")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Operation(summary = "获取用户信息")
    @Parameters({@Parameter(name = "userId", description = "用户id", required = true)})
    @GetMapping("/info")
    public ResponseWrapper<UserInfo> getUserInfo(Long userId) {
        ServiceResult<UserInfo> res = userService.getUserInfo(userId);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        } else {
            return ResponseWrapper.data(res.getData());
        }
    }

    @Operation(summary = "更新用户信息")
    @PostMapping("/update")
    public ResponseWrapper<Void> updateUser(Long userId, String description, String phone, String email, String avatarUrl, String sex, Integer age, Constants.UserRelativeType relativeType) {
        ServiceResult<Void> res = userService.updateUser(userId, description, phone, email, avatarUrl, sex, age, relativeType);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        } else {
            return ResponseWrapper.status(res.isSuccess());
        }
    }

    @Operation(summary = "删除用户")
    @Parameters({@Parameter(name = "userId", description = "用户id", required = true)})
    @GetMapping("/delete")
    public ResponseWrapper<Void> deleteUser(Long userId) {
        ServiceResult<Void> res = userService.deleteUser(userId);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        } else {
            return ResponseWrapper.status(res.isSuccess());
        }
    }

    @Operation(summary = "收藏用户")
    @PostMapping("fav")
    @Parameters({@Parameter(name = "favId", description = "被收藏用户id", required = true), @Parameter(name = "nickName", description = "昵称", required = true), @Parameter(name = "userId", description = "用户id", required = true)})
    public ResponseWrapper<Void> favUser(Long favId, String nickName, Long userId) {
        ServiceResult<Void> res = userService.favUser(favId, nickName, userId);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        } else {
            return ResponseWrapper.status(res.isSuccess());
        }
    }

    @Operation(summary = "上传头像")
    @PostMapping("avatar")
    @Parameters({@Parameter(name = "file", description = "文件", required = true)})
    public ResponseWrapper<String> updateAvatar(MultipartFile file) {
        ServiceResult<String> res = userService.updateAvatar(file);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        } else {
            return ResponseWrapper.data(res.getData());
        }
    }

    @GetMapping("/search")
    @Operation(summary = "搜索用户")
    @Parameters({@Parameter(name = "homeId", description = "家庭id", required = false), @Parameter(name = "keyword", description = "关键字", required = false), @Parameter(name = "email", description = "邮箱", required = false), @Parameter(name = "phone", description = "手机号", required = false), @Parameter(name = "pageNum", description = "页码", required = true), @Parameter(name = "pageSize", description = "页大小", required = true)})
    ResponseWrapper<PageResult<UserInfo>> searchUserInfo(Long homeId, String keyword, String email, String phone, Integer pageNum, Integer pageSize) {
        ServiceResult<PageResult<UserInfo>> res = userService.searchUserInfo(homeId, keyword, email, phone, pageNum, pageSize);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        } else {
            return ResponseWrapper.data(res.getData());
        }
    }
}
