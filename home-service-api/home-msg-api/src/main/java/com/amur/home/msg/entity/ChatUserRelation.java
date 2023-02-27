package com.amur.home.msg.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName(value = "msg_chat_user")
@NoArgsConstructor
public class ChatUserRelation {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String nickname;
    private Long userId;
    private String chatId;
    private Boolean notify;
    private Boolean top;
    private Boolean mute;
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    @JsonIgnore
    private Integer version;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @JsonIgnore
    private Integer deleted;

    public ChatUserRelation(String id, String chatId, Long userId) {
        this.id = id;
        this.chatId = chatId;
        this.userId = userId;
        this.setNickname("用户" + userId);
        this.setNotify(true);
        this.setTop(false);
        this.setMute(false);
    }
}
