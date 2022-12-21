package com.amur.homeuser.controller;

import com.amur.home.util.ResponseWrapper;
import com.amur.homeuser.entity.UserEntity;
import com.amur.homeuser.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "用户模块", tags = "user")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation("获取用户信息")
    @GetMapping("/getinfo")
    public ResponseWrapper<UserEntity> getUserInfo(@ApiParam("userid") Long userId) {
        return ResponseWrapper.data(userService.getUserInfo(userId));
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public ResponseWrapper updateUser(UserEntity userEntity) {
        return ResponseWrapper.status(userService.updateUser(userEntity));
    }

    @ApiOperation("删除用户")
    @GetMapping("/delete")
    public ResponseWrapper deleteUser(@ApiParam("userid") Long userId) {
        return ResponseWrapper.status(userService.deleteUser(userId));
    }

    @ApiOperation("创建用户")
    @PostMapping("/create")
    public ResponseWrapper<Long> createUser(UserEntity userEntity) {
        return ResponseWrapper.data(userService.createUser(userEntity));
    }

}
