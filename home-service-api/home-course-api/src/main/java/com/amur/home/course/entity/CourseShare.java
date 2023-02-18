package com.amur.home.course.entity;

import com.amur.home.common.Constants;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("course_list")
public class CourseShare {
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String token;
    private Long courseId;
    private Long inviterId;
    private Constants.InviteAs inviteAs;
    private Date expireTime;
}
