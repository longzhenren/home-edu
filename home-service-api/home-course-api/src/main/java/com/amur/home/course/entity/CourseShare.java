package com.amur.home.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course_list")
public class CourseShare {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String token;
    private String courseId;
    private String expireTime;
}
