package com.amur.home.course.entity;

import com.amur.home.common.Constants;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("course_share")
public class CourseShare {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String token;
    private Long courseId;
    private Long inviterId;
    private Constants.InviteAs inviteAs;
    private Date expireTime;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;
}
