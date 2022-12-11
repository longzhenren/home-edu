package com.amur.homeuser.entity;

import com.amur.home.common.Constants.UserRelativeType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserEntity {
    private String id;
    private String name;
    private String description;
    private String avatarUrl;
    private String homeId;
    private UserRelativeType relativeType;
    @Version
    private Integer version;
}
