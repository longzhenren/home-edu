package com.amur.home.user.controller;

import com.amur.home.user.entity.UserEntity;
import com.amur.home.user.service.UserService;
import com.amur.home.util.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Tag(name = "用户模块")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Operation(summary = "获取用户信息")
    @Parameters({@Parameter(name = "userId", description = "用户id", required = true)})
    @GetMapping("/getinfo")
    public ResponseWrapper<UserEntity> getUserInfo(Long userId) {
        UserEntity user = userService.getUserInfo(userId);
        user.setPassword(null);
        return ResponseWrapper.data(user);
    }

    @Operation(summary = "更新用户信息")
    @Parameters({@Parameter(name = "userEntity", description = "用户实体", required = true)})
    @PostMapping("/update")
    public ResponseWrapper<?> updateUser(UserEntity userEntity) {
        return ResponseWrapper.status(userService.updateUser(userEntity));
    }

    @Operation(summary = "删除用户")
    @Parameters({@Parameter(name = "userId", description = "用户id", required = true)})
    @GetMapping("/delete")
    public ResponseWrapper<?> deleteUser(Long userId) {
        return ResponseWrapper.status(userService.deleteUser(userId));
    }

    @Operation(summary = "创建用户")
    @Parameters({@Parameter(name = "userEntity", description = "用户实体", required = true)})
    @PostMapping("/create")
    public ResponseWrapper<Long> createUser(UserEntity userEntity) {
        return ResponseWrapper.data(userService.createUser(userEntity));
    }

    @Operation(summary = "修改密码")
    @Parameters({@Parameter(name = "userId", description = "用户id", required = true),
            @Parameter(name = "oldPassword", description = "旧密码", required = true),
            @Parameter(name = "newPassword", description = "新密码", required = true)})
    @PostMapping("/updatePassword")
    public ResponseWrapper<?> updatePassword(Long userId, String oldPassword, String newPassword) {
        return ResponseWrapper.status(userService.updatePassword(userId, oldPassword, newPassword));
    }

}
