package com.amur.home.user.entity;

import com.amur.home.common.Constants;
import com.amur.home.common.Constants.UserRelativeType;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_info", autoResultMap = true)
public class UserInfo {
    @TableId
    private Long id;
    private String name;
    private String description;
    private String phone;
    private String email;
    private String avatarUrl;
    private Long homeId;
    private String sex;
    private Integer age;
    private Integer likeCount;
    private Integer favCount;
    private UserRelativeType relativeType;
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    @JsonIgnore
    private Integer version;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @JsonIgnore
    private Integer deleted;

    public UserInfo(Long id, String username) {
        this.age = 0;
        this.avatarUrl = "";
        this.createTime = new Date();
        this.deleted = 0;
        this.description = "";
        this.email = "";
        this.favCount = 0;
        this.homeId = 0L;
        this.id = id;
        this.likeCount = 0;
        this.name = username;
        this.phone = "";
        this.sex = "";
        this.relativeType = Constants.UserRelativeType.NONE;
    }
}
