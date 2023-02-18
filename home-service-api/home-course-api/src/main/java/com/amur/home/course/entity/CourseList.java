package com.amur.home.course.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@TableName(value = "course_list", autoResultMap = true)
public class CourseList {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private Long homeId;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Set<Long> courseIds;
    private String title;
    private String description;
    private String coverUrl;
    private boolean open;
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
