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
    @GetMapping("/info")
    @Parameters({@Parameter(name = "homeId", description = "家庭id", required = true)})
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
    @Parameters({@Parameter(name = "keyword", description = "关键字", required = true)})
    public ResponseWrapper<List<HomeInfo>> searchHome(String keyword) {
        ServiceResult<List<HomeInfo>> res = homeService.searchHome(keyword);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "创建家庭")
    @PostMapping("/add")
    @Parameters({@Parameter(name = "name", description = "家庭名称", required = true), @Parameter(name = "description", description = "家庭描述", required = true), @Parameter(name = "userId", description = "创建者ID", required = true), @Parameter(name = "avatarUrl", description = "家庭头像", required = true)})
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
    @PostMapping("/del")
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
    @PostMapping("/user/add")
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
    @PostMapping("/user/del")
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
    @PostMapping("/admin/add")
    public ResponseWrapper<Void> setHomeAdmin(Long homeId, Long userId) {
        ServiceResult<Void> res = homeService.setHomeAdmin(homeId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.status(true);
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "移除家庭管理员")
    @Parameters({@Parameter(name = "homeId", description = "家庭id", required = true), @Parameter(name = "userId", description = "用户id", required = true)})
    @PostMapping("/admin/rm")
    public ResponseWrapper<Void> removeHomeAdmin(Long homeId, Long userId) {
        ServiceResult<Void> res = homeService.removeHomeAdmin(homeId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.status(true);
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }
}
