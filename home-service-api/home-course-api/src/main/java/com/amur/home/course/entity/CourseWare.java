package com.amur.home.course.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
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

    public CourseWare(Long courseId, String fileName, String description, String fileUrl) {
        this.id = UUID.randomUUID().toString();
        this.courseId = courseId;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.description = description;
    }
}
