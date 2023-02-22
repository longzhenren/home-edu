package com.amur.home.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
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
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    //    private String address;
    private String description;
    private String avatarUrl;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> imageUrls;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<Long> adminIds;
    private Long createUserId;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<Long> memberIds;
    private Long likeCount;                 //点赞数
    private Long favCount;                  //收藏数
    private Boolean open;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
