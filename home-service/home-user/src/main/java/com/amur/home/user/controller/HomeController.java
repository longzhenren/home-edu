package com.amur.home.user.controller;

import com.amur.home.user.entity.HomeInfo;
import com.amur.home.user.service.impl.HomeServiceImpl;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
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
    @GetMapping("/info")
    public ResponseWrapper<HomeInfo> getInfo(Long homeId) {
        return ResponseWrapper.data(homeService.getHomeInfo(homeId).getData());
    }

    @Operation(summary = "获取家庭列表")
    @GetMapping("/list")
    public ResponseWrapper<List<HomeInfo>> getList() {
        ServiceResult<List<HomeInfo>> res = homeService.getHomeList();
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "搜索公开的家庭")
    @GetMapping("/search")
    public ResponseWrapper<List<HomeInfo>> searchHome(String keyword) {
        ServiceResult<List<HomeInfo>> res = homeService.searchHome(keyword);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "创建家庭")
    @PostMapping("/create")
    public ResponseWrapper<Long> createHome(String name, String description, Long userId, String avatarUrl) {
        ServiceResult<Long> res = homeService.createHome(name, description, userId, avatarUrl);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }


    @Operation(summary = "更新家庭信息")
    @Parameters({@Parameter(name = "homeInfo", description = "家庭实体", required = true)})
    @PostMapping("/update")
    public ResponseWrapper<Void> updateHome(HomeInfo homeInfo) {
        ServiceResult<Void> res = homeService.updateHome(homeInfo);
        if (res.isSuccess()) {
            return ResponseWrapper.status(true);
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "删除家庭")
    @PostMapping("/delete")
    public ResponseWrapper<Void> deleteHome(Long homeId, Long userId) {
        ServiceResult<Void> res = homeService.deleteHome(homeId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.status(true);
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "家庭添加用户")
    @Parameters({@Parameter(name = "homeId", description = "家庭id", required = true), @Parameter(name = "userId", description = "用户id", required = true)})
    @PostMapping("/update_user")
    public ResponseWrapper<Void> updateHomeUser(Long homeId, Long userId) {
        ServiceResult<Void> res = homeService.updateHomeUser(homeId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.status(true);
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "家庭删除用户")
    @Parameters({@Parameter(name = "homeId", description = "家庭id", required = true), @Parameter(name = "userId", description = "用户id", required = true)})
    @PostMapping("/delete_user")
    public ResponseWrapper<Void> deleteHomeUser(Long homeId, Long userId) {
        ServiceResult<Void> res = homeService.deleteHomeUser(homeId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.status(true);
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "设置家庭管理员")
    @Parameters({@Parameter(name = "homeId", description = "家庭id", required = true), @Parameter(name = "userId", description = "用户id", required = true)})
    @PostMapping("/set_admin")
    public ResponseWrapper<Void> setHomeAdmin(Long homeId, Long userId) {
        ServiceResult<Void> res = homeService.setHomeAdmin(homeId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.status(true);
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }


}
