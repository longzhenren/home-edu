package com.amur.home.user.controller;

import com.amur.home.user.entity.HomeEntity;
import com.amur.home.user.service.impl.HomeServiceImpl;
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
import java.util.List;

@Tag(name = "家庭模块")
@RestController
@RequestMapping("/home")
@Slf4j
public class HomeController {
    @Resource
    private HomeServiceImpl homeService;

    @Operation(summary = "获取家庭信息")
    @Parameters({@Parameter(name = "homeId", description = "家庭id", required = true)})
    @GetMapping("/get_info")
    public ResponseWrapper<HomeEntity> getInfo(Long homeId) {
        return ResponseWrapper.data(homeService.getHomeInfo(homeId));
    }

    @Operation(summary = "获取家庭列表")
    @GetMapping("/get_list")
    public ResponseWrapper<List<HomeEntity>> getList() {
        return ResponseWrapper.data(homeService.getHomeList());
    }

    @Operation(summary = "创建家庭")
    @Parameters({@Parameter(name = "homeEntity", description = "家庭实体", required = true)})
    @PostMapping("/create")
    public ResponseWrapper<Long> createHome(HomeEntity homeEntity) {
        return ResponseWrapper.data(homeService.createHome(homeEntity));
    }


    @Operation(summary = "更新家庭信息")
    @Parameters({@Parameter(name = "homeEntity", description = "家庭实体", required = true)})
    @PostMapping("/update")
    public ResponseWrapper updateHome(HomeEntity homeEntity) {
        return ResponseWrapper.status(homeService.updateHome(homeEntity));
    }

    @Operation(summary = "删除家庭")
    @Parameters({@Parameter(name = "homeId", description = "家庭id", required = true)})
    @PostMapping("/delete")
    public ResponseWrapper deleteHome(Long homeId) {
        return ResponseWrapper.status(homeService.deleteHome(homeId));
    }

    @Operation(summary = "家庭添加用户")
    @Parameters({@Parameter(name = "homeId", description = "家庭id", required = true), @Parameter(name = "userId", description = "用户id", required = true)})
    @PostMapping("/update_user")
    public ResponseWrapper updateHomeUser(Long homeId, Long userId) {
        return ResponseWrapper.status(homeService.updateHomeUser(homeId, userId));
    }

    @Operation(summary = "家庭删除用户")
    @Parameters({@Parameter(name = "homeId", description = "家庭id", required = true), @Parameter(name = "userId", description = "用户id", required = true)})
    @PostMapping("/delete_user")
    public ResponseWrapper deleteHomeUser(Long homeId, Long userId) {
        return ResponseWrapper.status(homeService.deleteHomeUser(homeId, userId));
    }

    @Operation(summary = "设置家庭管理员")
    @Parameters({@Parameter(name = "homeId", description = "家庭id", required = true), @Parameter(name = "userId", description = "用户id", required = true)})
    @PostMapping("/set_admin")
    public ResponseWrapper setHomeAdmin(Long homeId, Long userId) {
        return ResponseWrapper.status(homeService.setHomeAdmin(homeId, userId));
    }


}
