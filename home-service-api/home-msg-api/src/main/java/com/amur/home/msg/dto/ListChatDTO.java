package com.amur.home.msg.dto;

import com.amur.home.msg.entity.Chat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListChatDTO {
    List<Chat> topChatList;
    List<Chat> otherChatList;
}
