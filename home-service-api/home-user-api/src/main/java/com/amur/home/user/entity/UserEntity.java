package com.amur.home.user.entity;

import com.amur.home.common.Constants.UserRelativeType;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user", autoResultMap = true)
public class UserEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String description;
    private String phone;
    private String password;
    private String email;
    private String avatarUrl;
    private Long homeId;
    private String sex;
    private Integer age;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<String> permissions;
    private UserRelativeType relativeType;
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
