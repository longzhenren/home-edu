package com.amur.home.course.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("course_list")
public class CourseList {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private Long homeId;
    private String courseIds;
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
