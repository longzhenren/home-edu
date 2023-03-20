package com.amur.home.user.entity;

import com.amur.home.user.handler.SetTypeHandler;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

@Data
@TableName(value = "user_like", autoResultMap = true)
public class UserLike {
    @TableId
    private Long id;
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> homeIds;
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> userIds;
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> courseIds;
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> courseWareIds;
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> courseListIds;
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

    public UserLike(Long id) {
        this.id = id;
        this.userIds = Collections.emptySet();
        this.homeIds = Collections.emptySet();
        this.courseIds = Collections.emptySet();
        this.courseWareIds = Collections.emptySet();
        this.courseListIds = Collections.emptySet();
    }
}
