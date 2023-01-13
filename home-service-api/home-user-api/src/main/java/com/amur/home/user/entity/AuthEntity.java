package com.amur.home.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户基础信息
     */
    private UserEntity user;

    /**
     * 权限标识集合
     */
    private List<String> permissions;

    /**
     * 角色集合
     */
    private List<String> roles;

    /**
     * 第三方授权id
     */
    private String oauthId;

}
