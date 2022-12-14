package com.amur.homeuser.controller;

import com.amur.home.util.ResponseWrapper;
import com.amur.homeuser.dto.AddHomeImageDto;
import com.amur.homeuser.entity.HomeEntity;
import com.amur.homeuser.service.impl.HomeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@Slf4j
public class HomeController {
    private HomeServiceImpl homeService;
    @GetMapping("/getinfo")
    public ResponseWrapper<HomeEntity> getBaseInfo(@RequestParam("homeid") Long homeId) {
        return ResponseWrapper.data(homeService.getHomeInfo(homeId));
    }
    @GetMapping("/getlist")
    public ResponseWrapper<List<HomeEntity>> getList() {
        return ResponseWrapper.data(homeService.getHomeList());
    }
    @PostMapping("/create")
    public ResponseWrapper<Long> createHome(HomeEntity homeEntity) {
        return ResponseWrapper.data(homeService.createHome(homeEntity));
    }
    @PostMapping("/update")
    public ResponseWrapper<Boolean> updateHome(HomeEntity homeEntity) {
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
