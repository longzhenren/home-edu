package com.amur.home.user.controller;

import com.amur.home.user.entity.UserUnity;
import com.amur.home.user.service.UserUnityService;
import com.amur.home.util.ResponseWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Tag(name = "用户Unity信息")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/unity")
public class UnityController {

    @Resource
    private UserUnityService userUnityService;

    @GetMapping("/user")
    @Operation(summary = "根据ID查询用户信息")
    public ResponseWrapper<UserUnity> getUserUnityById(Long id) {
        return ResponseWrapper.data(userUnityService.getById(id));
    }

//    @GetMapping
//    @Operation(summary = "查询所有用户信息")
//    public ResponseWrapper<List<UserUnity>> getAllUserUnity() {
//        return ResponseWrapper.data(userUnityService.list());
//    }
//
//    @PostMapping
//    @Operation(summary = "添加用户信息")
//    public ResponseWrapper<?> addUserUnity(@RequestBody UserUnity userUnity) {
//        return ResponseWrapper.status(userUnityService.save(userUnity));
//    }

    @PostMapping("/update/text")
    @Operation(summary = "根据ID更新用户信息")
    public ResponseWrapper<?> updateText(Long id, String text) {
        UserUnity userUnity = userUnityService.getById(id);
        userUnity.setText(text);
        return ResponseWrapper.status(userUnityService.updateById(userUnity));
    }

    @GetMapping("/text")
    @Operation(summary = "根据ID查询用户信息")
    public ResponseWrapper<String> getText(Long id) {
        return ResponseWrapper.data(userUnityService.getById(id).getText());
    }

    @GetMapping("/model")
    @Operation(summary = "根据ID查询用户信息")
    public ResponseWrapper<Long> getModel(Long id) {
        return ResponseWrapper.data(userUnityService.getById(id).getModelId());
    }

    @PostMapping("/update/model")
    @Operation(summary = "根据ID更新用户信息")
    public ResponseWrapper<?> updateUserUnityModel(Long id, Long modelId) {
        UserUnity userUnity = userUnityService.getById(id);
        userUnity.setModelId(modelId);
        return ResponseWrapper.status(userUnityService.updateById(userUnity));
    }

//    @DeleteMapping("/{id}")
//    @Operation(summary = "根据ID删除用户信息")
//    public ResponseWrapper<?> deleteUserUnity(@PathVariable Long id) {
//        return userUnityService.removeById(id);
//    }

}
