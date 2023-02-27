package com.amur.home.msg.service;


import com.amur.home.msg.dto.ChatDetailDTO;
import com.amur.home.msg.dto.ListChatDTO;
import com.amur.home.util.ServiceResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface MessageService {
    ServiceResult<Void> sendMsg(Long senderId, String message, String chatId);

    ServiceResult<Void> sendFile(Long senderId, MultipartFile file, String chatId);

    ServiceResult<String> createChat(Long creatorId, String name);

    ServiceResult<Void> addChatUser(String chatId, Long userId);

    ServiceResult<Void> delChatUser(String chatId, Long userId);

    ServiceResult<ListChatDTO> listChats(Long userId);

    ServiceResult<ChatDetailDTO> getChatDetail(String chatId);

    ServiceResult<Void> deleteChat(String chatId);

    ServiceResult<Void> clearChat(String chatId);

    ServiceResult<Void> leaveChat(String chatId, Long userId);

    ServiceResult<Void> joinChat(String chatId, Long userId);

    ServiceResult<String> inviteUser(String chatId, Long invitorId);

    ServiceResult<Void> kickUser(String chatId, Long userId);

    ServiceResult<Void> muteUserAdd(String chatId, Long userId);

    ServiceResult<Void> muteUserDel(String chatId, Long userId);

    ServiceResult<Void> transferChat(String chatId, Long userId);

    ServiceResult<Void> searchMsg(Long userId, String keyword);

    ServiceResult<Void> searchChat(Long userId, String keyword);

    ServiceResult<String> chatUserNickname(String chatId, Long userId, String nickname);

    ServiceResult<Void> chatTopDel(String chatId, Long userId);

    ServiceResult<Void> chatTopAdd(String chatId, Long userId);

    ServiceResult<Void> notifyOff(String chatId, Long userId);

    ServiceResult<Void> notifyOn(String chatId, Long userId);
}
