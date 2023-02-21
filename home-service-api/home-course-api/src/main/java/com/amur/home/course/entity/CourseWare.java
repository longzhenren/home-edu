package com.amur.home.course.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@TableName("course_ware")
public class CourseWare {
    @TableId
    private String id;
    private Long courseId;
    private String fileName;
    private String description;
    private String fileUrl;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<String, Object> additionalProperties;
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
