package com.amur.homeuser.entity;

import com.amur.home.common.Constants.UserRelativeType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserEntity {
    private Long id;
    private String name;
    private String description;
    private String phone;
    private String email;
    private String avatarUrl;
    private Long homeId;
    private UserRelativeType relativeType;
    private Date createTime;
    @Version
    private Integer version;
}
