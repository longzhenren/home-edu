package com.amur.home.user.entity;

import com.amur.home.user.handler.SetTypeHandler;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "home_info", autoResultMap = true)
public class HomeInfo {
    @TableId
    private Long id;
    private String name;
    //    private String address;
    private String description;
    private String avatarUrl;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> imageUrls;
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> adminIds;
    private Long createUserId;
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> memberIds;
    private Long likeCount;                 //点赞数
    private Long favCount;                  //收藏数
    private Boolean open;
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
}
