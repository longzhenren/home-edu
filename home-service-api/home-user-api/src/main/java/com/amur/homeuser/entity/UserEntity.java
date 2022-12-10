package com.amur.homeuser.entity;

import lombok.Data;

@Data
public class UserEntity {
    private String id;
    private String name;
    private String description;
    private String avatarUrl;
    private String homeId;
}
