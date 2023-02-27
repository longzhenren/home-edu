package com.amur.home.msg.controller;

import com.amur.home.msg.dto.ChatDetailDTO;
import com.amur.home.msg.dto.ListChatDTO;
import com.amur.home.msg.service.MessageService;
import com.amur.home.util.ResponseWrapper;
import com.amur.home.util.ServiceResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    @Operation(summary = "发送消息")
    @PostMapping("/send")
    @Parameters({@Parameter(name = "senderId", description = "发送者id"), @Parameter(name = "message", description = "消息"), @Parameter(name = "chatId", description = "聊天id")})
    public ResponseWrapper<Void> sendMsg(Long senderId, String message, String chatId) {
        ServiceResult<Void> res = messageService.sendMsg(senderId, message, chatId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "发送文件")
    @PostMapping("/send/file")
    @Parameters({@Parameter(name = "senderId", description = "发送者id"), @Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "file", description = "文件")})
    public ResponseWrapper<Void> sendFile(Long senderId, String chatId, MultipartFile file) {
        ServiceResult<Void> res = messageService.sendFile(senderId, file, chatId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "搜索聊天")
    @GetMapping("/search/chat")
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "keyword", description = "关键字")})
    public ResponseWrapper<Void> searchChat(Long userId, String keyword) {
        ServiceResult<Void> res = messageService.searchChat(userId, keyword);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "搜索消息")
    @GetMapping("/search/msg")
    @Parameters({@Parameter(name = "userId", description = "用户id"), @Parameter(name = "keyword", description = "关键字")})
    public ResponseWrapper<Void> searchMsg(Long userId, String keyword) {
        ServiceResult<Void> res = messageService.searchMsg(userId, keyword);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }


    @Operation(summary = "创建聊天")
    @PostMapping("/chat/create")
    @Parameters({@Parameter(name = "creatorId", description = "创建者id"), @Parameter(name = "name", description = "聊天名称")})
    public ResponseWrapper<String> createChat(Long creatorId, String name) {
        ServiceResult<String> res = messageService.createChat(creatorId, name);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "置顶聊天")
    @PostMapping("/chat/top/add")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Void> chatTopAdd(String chatId, Long userId) {
        ServiceResult<Void> res = messageService.chatTopAdd(chatId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "取消置顶聊天")
    @PostMapping("/chat/top/del")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Void> chatTopDel(String chatId, Long userId) {
        ServiceResult<Void> res = messageService.chatTopDel(chatId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "添加聊天用户")
    @PostMapping("/chat/user/add")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Void> addChatUser(String chatId, Long userId) {
        ServiceResult<Void> res = messageService.addChatUser(chatId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "修改聊天用户昵称")
    @PostMapping("/chat/user/nickname")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id"), @Parameter(name = "nickname", description = "昵称")})
    public ResponseWrapper<String> chatUserNickname(String chatId, Long userId, String nickname) {
        ServiceResult<String> res = messageService.chatUserNickname(chatId, userId, nickname);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "删除聊天用户")
    @PostMapping("/chat/user/del")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Void> delChatUser(String chatId, Long userId) {
        ServiceResult<Void> res = messageService.delChatUser(chatId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "获取聊天列表")
    @GetMapping("/chat/list")
    @Parameters({@Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<ListChatDTO> listChats(Long userId) {
        ServiceResult<ListChatDTO> res = messageService.listChats(userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "获取聊天详情")
    @GetMapping("/chat/detail")
    @Parameters({@Parameter(name = "chatId", description = "聊天id")})
    public ResponseWrapper<ChatDetailDTO> getChatDetail(String chatId) {
        ServiceResult<ChatDetailDTO> res = messageService.getChatDetail(chatId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "删除聊天")
    @PostMapping("/chat/delete")
    @Parameters({@Parameter(name = "chatId", description = "聊天id")})
    public ResponseWrapper<Void> deleteChat(String chatId) {
        ServiceResult<Void> res = messageService.deleteChat(chatId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "清空聊天")
    @PostMapping("/chat/clear")
    @Parameters({@Parameter(name = "chatId", description = "聊天id")})
    public ResponseWrapper<Void> clearChat(String chatId) {
        ServiceResult<Void> res = messageService.clearChat(chatId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }


    @Operation(summary = "退出聊天")
    @PostMapping("/chat/leave")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Void> leaveChat(String chatId, Long userId) {
        ServiceResult<Void> res = messageService.leaveChat(chatId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "加入聊天")
    @PostMapping("/chat/join")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Void> joinChat(String chatId, Long userId) {
        ServiceResult<Void> res = messageService.joinChat(chatId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "邀请用户加入聊天")
    @PostMapping("/chat/invite")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<String> inviteUser(String chatId, Long userId) {
        ServiceResult<String> res = messageService.inviteUser(chatId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "踢出聊天")
    @PostMapping("/chat/kick")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Void> kickUser(String chatId, Long userId) {
        ServiceResult<Void> res = messageService.kickUser(chatId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "禁言用户")
    @PostMapping("/chat/mute/add")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Void> muteUserAdd(String chatId, Long userId) {
        ServiceResult<Void> res = messageService.muteUserAdd(chatId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "解除禁言")
    @PostMapping("/chat/mute/del")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Void> muteUserDel(String chatId, Long userId) {
        ServiceResult<Void> res = messageService.muteUserDel(chatId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }

    @Operation(summary = "转让聊天")
    @PostMapping("/chat/transfer")
    @Parameters({@Parameter(name = "chatId", description = "聊天id"), @Parameter(name = "userId", description = "用户id")})
    public ResponseWrapper<Void> transferChat(String chatId, Long userId) {
        ServiceResult<Void> res = messageService.transferChat(chatId, userId);
        if (res.isSuccess()) {
            return ResponseWrapper.data(res.getData());
        } else {
            return ResponseWrapper.fail(res.getMessage());
        }
    }
}
