package com.amur.home.msg.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Tag(name = "通知公告服务")
@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
    @Resource
    private SimpMessagingTemplate messagingTemplate;

    public void sendAnnouncement(String payload) {
        messagingTemplate.convertAndSend("/topic/announcement", payload);
    }



}
