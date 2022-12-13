package com.amur.homeuser.controller;

import com.amur.homeuser.service.impl.HomeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    private HomeServiceImpl homeService;
    @GetMapping("/getbaseinfo")
    public String getBaseInfo(@RequestParam("homeid") Long homeId) {
        return homeService.getHomeInfo(homeId).toString();
    }
}
