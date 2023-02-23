package com.amur.home.course.entity;

import com.amur.home.course.handler.SetTypeHandler;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@TableName(value = "course_list", autoResultMap = true)
public class CourseList {
    @TableId
    private Long id;
    private Long homeId;
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> courseIds;
    private String title;
    private String description;
    private String coverUrl;
    private boolean open;
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
}
