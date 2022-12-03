package com.amur.home.msg.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "msg_msg")
public class Message {
    @TableId(type = IdType.ASSIGN_UUID)
    String id;
    String message;
    String chatId;
    Long senderId;
    Boolean callBack;
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

    public Message(String id, String message, String chatId, Long senderId) {
        this.id = id;
        this.message = message;
        this.chatId = chatId;
        this.senderId = senderId;
        this.callBack = false;
    }
}
