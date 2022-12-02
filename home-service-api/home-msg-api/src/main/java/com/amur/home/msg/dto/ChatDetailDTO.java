package com.amur.home.msg.dto;

import com.amur.home.msg.entity.Chat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class ChatDetailDTO {
    Chat chat;
    //    String lastMessage;
    Date lastMessageTime;
    //    String lastMessageSender;
    List<Long> userIds;

    public ChatDetailDTO(Chat chat, Date lastMessageTime, List<Long> userIds) {
        this.chat = chat;
//        this.lastMessage = "";
        this.lastMessageTime = lastMessageTime;
//        this.lastMessageSender = null;
        this.userIds = userIds;
    }

}
