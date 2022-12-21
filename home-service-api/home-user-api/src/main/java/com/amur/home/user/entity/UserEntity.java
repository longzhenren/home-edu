package com.amur.home.user.entity;

import com.amur.home.common.Constants.UserRelativeType;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserEntity {
    @TableId(value = "id")
    private Long id;
    private String name;
    private String description;
    private String phone;
    private String email;
    private String avatarUrl;
    private Long homeId;
    private String sex;
    private Integer age;
    private UserRelativeType relativeType;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT)
    private Date updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
