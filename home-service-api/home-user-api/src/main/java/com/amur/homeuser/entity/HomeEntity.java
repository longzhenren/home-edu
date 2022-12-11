package com.amur.homeuser.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("home")
public class HomeEntity {
    private String id;
    private String name;
    private String description;
    private String avatarUrl;
    private List<String> photoUrls;
    private String adminId;
    private List<String> homeUserIds;
    @Version
    private Integer version;
}
