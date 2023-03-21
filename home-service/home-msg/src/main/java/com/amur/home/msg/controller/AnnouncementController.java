package com.amur.home.msg.controller;

import com.amur.home.dto.PageResult;
import com.amur.home.msg.entity.HomeAnnouncement;
import com.amur.home.msg.entity.SystemAnnouncement;
import com.amur.home.msg.service.AnnouncementService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Set;

@Tag(name = "通知公告服务")
@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
    @Resource
    private AnnouncementService announcementService;

    @Operation(summary = "创建系统通知")
    @PostMapping("/sys/create")
    @Parameters({@Parameter(name = "title", description = "标题"), @Parameter(name = "message", description = "内容"), @Parameter(name = "userIds", description = "接收人id集合"), @Parameter(name = "sendTime", description = "发送时间")})
    public ResponseWrapper<Long> createSystemAnnouncement(String title, String message, Set<Long> userIds, Date sendTime) {
        ServiceResult<Long> res = announcementService.createSystemAnnouncement(title, message, userIds, sendTime);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "创建家庭通知")
    @PostMapping("/home/create")
    @Parameters({@Parameter(name = "senderId", description = "发送人id"), @Parameter(name = "homeId", description = "家庭id"), @Parameter(name = "title", description = "标题"), @Parameter(name = "message", description = "内容"), @Parameter(name = "userIds", description = "接收人id集合"), @Parameter(name = "sendTime", description = "发送时间")})
    public ResponseWrapper<Long> createHomeAnnouncement(Long senderId, Long homeId, String title, String message, Set<Long> userIds, Date sendTime) {
        ServiceResult<Long> res = announcementService.createHomeAnnouncement(senderId, homeId, title, message, userIds, sendTime);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "获取家庭通知列表")
    @GetMapping("/home/list/user")
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "page", description = "页码"), @Parameter(name = "size", description = "每页数量")})
    public ResponseWrapper<PageResult<HomeAnnouncement>> getHomeAnnouncementList(Long userId, Integer page, Integer size) {
        ServiceResult<PageResult<HomeAnnouncement>> res = announcementService.getHomeAnnouncementList(userId, page, size);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "获取家庭通知列表")
    @GetMapping("/home/list/home")
    @Parameters({@Parameter(name = "homeId", description = "家庭id"), @Parameter(name = "page", description = "页码"), @Parameter(name = "size", description = "每页数量")})
    public ResponseWrapper<PageResult<HomeAnnouncement>> getHomeAnnouncementListById(Long homeId, Integer page, Integer size) {
        ServiceResult<PageResult<HomeAnnouncement>> res = announcementService.getHomeAnnouncementListByHomeId(homeId, page, size);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "获取家庭通知详情")
    @GetMapping("/home/detail")
    @Parameters({@Parameter(name = "announcementId", description = "通知id")})
    public ResponseWrapper<HomeAnnouncement> getHomeAnnouncementDetail(Long announcementId) {
        ServiceResult<HomeAnnouncement> res = announcementService.getHomeAnnouncementDetail(announcementId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "获取系统通知列表")
    @GetMapping("/sys/list")
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "page", description = "页码"), @Parameter(name = "size", description = "每页数量")})
    public ResponseWrapper<PageResult<SystemAnnouncement>> getSystemAnnouncementList(Long userId, Integer page, Integer size) {
        ServiceResult<PageResult<SystemAnnouncement>> res = announcementService.getSystemAnnouncementList(userId, page, size);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "获取系统通知详情")
    @GetMapping("/sys/detail")
    @Parameters({@Parameter(name = "announcementId", description = "通知id")})
    public ResponseWrapper<SystemAnnouncement> getSystemAnnouncementDetail(Long announcementId) {
        ServiceResult<SystemAnnouncement> res = announcementService.getSystemAnnouncementDetail(announcementId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "删除系统通知")
    @PostMapping("/sys/delete")
    @Parameters({@Parameter(name = "announcementId", description = "通知id")})
    public ResponseWrapper<?> deleteSystemAnnouncement(Long announcementId) {
        ServiceResult<?> res = announcementService.deleteAnnouncement(announcementId, "system");
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "删除家庭通知")
    @PostMapping("/home/delete")
    @Parameters({@Parameter(name = "announcementId", description = "通知id")})
    public ResponseWrapper<?> deleteHomeAnnouncement(Long announcementId) {
        ServiceResult<?> res = announcementService.deleteAnnouncement(announcementId, "home");
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "更新系统通知")
    @PostMapping("/sys/update")
    @Parameters({@Parameter(name = "announcementId", description = "通知id"), @Parameter(name = "title", description = "标题"), @Parameter(name = "message", description = "内容"), @Parameter(name = "userIds", description = "接收人id集合"), @Parameter(name = "sendTime", description = "发送时间")})
    public ResponseWrapper<?> updateSystemAnnouncement(Long announcementId, String title, String message, Set<Long> userIds, Date sendTime) {
        ServiceResult<?> res = announcementService.updateSystemAnnouncement(announcementId, title, message, userIds, sendTime);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "更新家庭通知")
    @PostMapping("/home/update")
    @Parameters({@Parameter(name = "announcementId", description = "通知id"), @Parameter(name = "senderId", description = "发送人id"), @Parameter(name = "homeId", description = "家庭id"), @Parameter(name = "title", description = "标题"), @Parameter(name = "message", description = "内容"), @Parameter(name = "userIds", description = "接收人id集合"), @Parameter(name = "sendTime", description = "发送时间")})
    public ResponseWrapper<?> updateHomeAnnouncement(Long announcementId, String title, String message, Set<Long> userIds, Date sendTime) {
        ServiceResult<?> res = announcementService.updateHomeAnnouncement(announcementId, title, message, userIds, sendTime);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }

    }
}
