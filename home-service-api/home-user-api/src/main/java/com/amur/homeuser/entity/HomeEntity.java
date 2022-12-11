package com.amur.homeuser.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeEntity {
    private String id;
    private String name;
    private String description;
    private String avatarUrl;
    private List<String> photoUrls;
    private String adminId;
    private List<String> homeUserIds;

}
