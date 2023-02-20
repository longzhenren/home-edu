package com.amur.home.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@TableName(value = "user_auth", autoResultMap = true)
public class UserAuth implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    private String password;

    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<String> roles;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<String> permissions;
}
