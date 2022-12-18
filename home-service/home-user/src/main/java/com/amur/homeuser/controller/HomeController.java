package com.amur.homeuser.controller;

import com.amur.home.util.ResponseWrapper;
import com.amur.homeuser.dto.AddHomeImageDto;
import com.amur.homeuser.entity.HomeEntity;
import com.amur.homeuser.service.impl.HomeServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "家庭模块")
@RestController
@RequestMapping("/home-user")
@Slf4j
public class HomeController {
    @Resource
    private HomeServiceImpl homeService;
    @GetMapping("/home/getinfo")
    public ResponseWrapper<HomeEntity> getBaseInfo(@RequestParam("homeid") Long homeId) {
        return ResponseWrapper.data(homeService.getHomeInfo(homeId));
    }
    @GetMapping("/home/getlist")
    public ResponseWrapper<List<HomeEntity>> getList() {
        return ResponseWrapper.data(homeService.getHomeList());
    }
    @PostMapping("/home/create")
    public ResponseWrapper<Long> createHome(HomeEntity homeEntity) {
        return ResponseWrapper.data(homeService.createHome(homeEntity));
    }
    @PostMapping("/home/update")
    public ResponseWrapper<Boolean> updateHome(HomeEntity homeEntity) {
        return ResponseWrapper.data(homeService.updateHome(homeEntity));
    }
    @PostMapping("/home/delete")
    public ResponseWrapper<Boolean> deleteHome(@RequestParam("homeid") Long homeId) {
        return ResponseWrapper.data(homeService.deleteHome(homeId));
    }
    @PostMapping("/home/updateuser")
    public ResponseWrapper<Boolean> updateHomeUser(@RequestParam("homeid") Long homeId, @RequestParam("userid") Long userId) {
        return ResponseWrapper.data(homeService.updateHomeUser(homeId, userId));
    }
    @PostMapping("/home/deleteuser")
    public ResponseWrapper<Boolean> deleteHomeUser(@RequestParam("homeid") Long homeId, @RequestParam("userid") Long userId) {
        return ResponseWrapper.data(homeService.deleteHomeUser(homeId, userId));
    }
    @PostMapping("/home/setadmin")
    public ResponseWrapper<Boolean> setHomeAdmin(@RequestParam("homeid") Long homeId, @RequestParam("userid") Long userId) {
        return ResponseWrapper.data(homeService.setHomeAdmin(homeId, userId));
    }
    @PostMapping("/home/addimage")
    public ResponseWrapper<Boolean> addHomeImage(@RequestBody AddHomeImageDto request) {
        return ResponseWrapper.data(homeService.addHomeImage(request));
    }

}
