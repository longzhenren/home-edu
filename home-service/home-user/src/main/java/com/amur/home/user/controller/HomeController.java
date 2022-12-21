package com.amur.home.user.controller;

import com.amur.home.util.ResponseWrapper;
import com.amur.home.user.dto.AddHomeImageDto;
import com.amur.home.user.entity.HomeEntity;
import com.amur.home.user.service.impl.HomeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "家庭模块", tags = "home")
@RestController
@RequestMapping("/home")
@Slf4j
public class HomeController {
    @Resource
    private HomeServiceImpl homeService;

    @ApiOperation("获取家庭信息")
    @GetMapping("/getinfo")
    public ResponseWrapper<HomeEntity> getInfo(@ApiParam(value = "homeid", required = true) Long homeId) {
        return ResponseWrapper.data(homeService.getHomeInfo(homeId));
    }

    @ApiOperation("获取家庭列表")
    @GetMapping("/getlist")
    public ResponseWrapper<List<HomeEntity>> getList() {
        return ResponseWrapper.data(homeService.getHomeList());
    }

    @ApiOperation("创建家庭")
    @PostMapping("/create")
    public ResponseWrapper<Long> createHome(HomeEntity homeEntity) {
        return ResponseWrapper.data(homeService.createHome(homeEntity));
    }

    @ApiOperation("更新家庭信息")
    @PostMapping("/update")
    public ResponseWrapper updateHome(@ApiParam(value = "homeEntity", required = true) HomeEntity homeEntity) {
        return ResponseWrapper.status(homeService.updateHome(homeEntity));
    }

    @PostMapping("/delete")
    public ResponseWrapper deleteHome(@ApiParam(value = "homeId", required = true) Long homeId) {
        return ResponseWrapper.status(homeService.deleteHome(homeId));
    }

    @PostMapping("/updateuser")
    public ResponseWrapper updateHomeUser(@ApiParam(value = "homeId", required = true) Long homeId, @ApiParam(value = "userId", required = true) Long userId) {
        return ResponseWrapper.status(homeService.updateHomeUser(homeId, userId));
    }

    @PostMapping("/deleteuser")
    public ResponseWrapper deleteHomeUser(@ApiParam(value = "homeId", required = true) Long homeId, @ApiParam(value = "userId", required = true) Long userId) {
        return ResponseWrapper.status(homeService.deleteHomeUser(homeId, userId));
    }

    @PostMapping("/setadmin")
    public ResponseWrapper setHomeAdmin(@ApiParam(value = "homeId", required = true) Long homeId, @ApiParam(value = "userId", required = true) Long userId) {
        return ResponseWrapper.status(homeService.setHomeAdmin(homeId, userId));
    }

    @PostMapping("/addimage")
    public ResponseWrapper addHomeImage(@ApiParam(value = "AddHomeImageDto", required = true) @RequestBody AddHomeImageDto request) {
        return ResponseWrapper.status(homeService.addHomeImage(request));
    }

}
