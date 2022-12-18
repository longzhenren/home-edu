package com.amur.homeuser.controller;

import com.amur.home.util.ResponseWrapper;
import com.amur.homeuser.dto.AddHomeImageDto;
import com.amur.homeuser.entity.HomeEntity;
import com.amur.homeuser.service.impl.HomeServiceImpl;
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
    public ResponseWrapper<Boolean> updateHome(@ApiParam(value = "homeEntity", required = true) HomeEntity homeEntity) {
        return ResponseWrapper.data(homeService.updateHome(homeEntity));
    }

    @PostMapping("/delete")
    public ResponseWrapper<Boolean> deleteHome(@RequestParam("homeid") Long homeId) {
        return ResponseWrapper.data(homeService.deleteHome(homeId));
    }

    @PostMapping("/updateuser")
    public ResponseWrapper<Boolean> updateHomeUser(@RequestParam("homeid") Long homeId, @RequestParam("userid") Long userId) {
        return ResponseWrapper.data(homeService.updateHomeUser(homeId, userId));
    }

    @PostMapping("/deleteuser")
    public ResponseWrapper<Boolean> deleteHomeUser(@RequestParam("homeid") Long homeId, @RequestParam("userid") Long userId) {
        return ResponseWrapper.data(homeService.deleteHomeUser(homeId, userId));
    }

    @PostMapping("/setadmin")
    public ResponseWrapper<Boolean> setHomeAdmin(@RequestParam("homeid") Long homeId, @RequestParam("userid") Long userId) {
        return ResponseWrapper.data(homeService.setHomeAdmin(homeId, userId));
    }

    @PostMapping("/addimage")
    public ResponseWrapper<Boolean> addHomeImage(@RequestBody AddHomeImageDto request) {
        return ResponseWrapper.data(homeService.addHomeImage(request));
    }

}
