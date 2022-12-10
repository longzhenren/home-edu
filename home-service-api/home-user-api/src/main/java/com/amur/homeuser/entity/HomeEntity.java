package com.amur.homeuser.entity;

import lombok.Data;

import java.util.List;

@Data
public class HomeEntity {
    private String id;
    private String name;
    private String description;
    private String avatarUrl;
    private List<String> photoUrls;
    private String adminId;
    private List<String> homeUserIds;

}
