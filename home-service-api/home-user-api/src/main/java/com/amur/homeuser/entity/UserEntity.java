package com.amur.homeuser.entity;

import com.amur.home.common.Constants.UserRelativeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private String id;
    private String name;
    private String description;
    private String avatarUrl;
    private String homeId;
    private UserRelativeType relativeType;
}
