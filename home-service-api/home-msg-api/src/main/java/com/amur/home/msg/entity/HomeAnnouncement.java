package com.amur.home.msg.entity;


import com.amur.home.msg.handler.SetTypeHandler;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@TableName(value = "msg_home", autoResultMap = true)
public class HomeAnnouncement {
    @TableId
    private Long id;
    private Long homeId;
    private Long senderId;
    private String title;
    private String message;
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> userIds;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendTime;
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

    public HomeAnnouncement(Long id, Long homeId, Long senderId, String title, String message, Set<Long> userIds, Date sendTime) {
        this.id = id;
        this.homeId = homeId;
        this.senderId = senderId;
        this.title = title;
        this.message = message;
        this.userIds = userIds;
        this.sendTime = sendTime;
    }
}
