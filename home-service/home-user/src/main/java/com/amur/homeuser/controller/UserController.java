package com.amur.homeuser.controller;

import com.amur.homeuser.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "用户模块")
@Slf4j
@RestController
@RequestMapping("/home-user")
public class UserController {
    @Resource
    private UserService userService;
}
