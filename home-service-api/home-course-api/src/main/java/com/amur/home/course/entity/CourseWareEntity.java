package com.amur.home.course.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("course_ware")
public class CourseWareEntity {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private Long courseId;
    private String title;
    private String description;
    private String icon;
    private String url;
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
