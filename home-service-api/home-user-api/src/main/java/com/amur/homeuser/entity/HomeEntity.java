package com.amur.homeuser.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("home")
public class HomeEntity {
    private Long id;
    private String name;
    private String address;
    private String description;
    private String avatarUrl;
    private List<String> imageUrls;
    private Long adminId;
    private List<Long> homeUserIds;
    private Date createTime;
    @Version
    private Integer version;
}
