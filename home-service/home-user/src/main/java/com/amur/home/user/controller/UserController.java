package com.amur.home.user.controller;

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
    @Parameters({@Parameter(name = "userInfo", description = "用户实体", required = true)})
    @PostMapping("/update")
    public ResponseWrapper<Void> updateUser(UserInfo userInfo) {
        ServiceResult<Void> res = userService.updateUser(userInfo);
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
    public ResponseWrapper<Void> favUser(Long favId, String nickName, Long userId) {
        ServiceResult<Void> res = userService.favUser(favId, nickName, userId);
        if (!res.isSuccess()) {
            return ResponseWrapper.fail(res.getMessage());
        } else {
            return ResponseWrapper.status(res.isSuccess());
        }
    }

}
