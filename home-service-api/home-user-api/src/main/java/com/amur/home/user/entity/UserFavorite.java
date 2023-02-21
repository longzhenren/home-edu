package com.amur.home.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.util.Date;
import java.util.Map;
import java.util.Set;

@Data
@TableName(value = "user_fav", autoResultMap = true)
public class UserFavorite {
    @TableId
    private Long id;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<Long> homeIds;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<Long> userIds;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<Long> courseIds;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<Long> courseWareIds;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<Long> courseListIds;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<Long, String> userMap; // id到别名
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
