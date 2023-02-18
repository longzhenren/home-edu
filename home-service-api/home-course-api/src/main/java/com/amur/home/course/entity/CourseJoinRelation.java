package com.amur.home.course.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "course_join", autoResultMap = true)
public class CourseJoinRelation {
    private Long id;
    private Long userId;
    private Long homeId;
    private Long courseId;
}
