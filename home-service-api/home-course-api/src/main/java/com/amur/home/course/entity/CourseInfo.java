package com.amur.home.course.entity;

import com.amur.home.course.handler.SetTypeHandler;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@TableName(value = "course_info", autoResultMap = true)
public class CourseInfo {
    @TableId
    private Long id;
    private String name;
    private String description;
    private Long homeId;
    private String coverUrl;
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> teacherIds;
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> studentIds;  //  听课人员
    @TableField(typeHandler = SetTypeHandler.class)
    private Set<Long> issueIds;
    private String status;      //  课程状态
    private Date startTime;   //  开始时间
    private Date endTime;     //  结束时间
    private boolean open;       // 课程是否公开

    private Long likeCount;     //  点赞数
    private Long favCount;      //  收藏数
    private Long commentCount;  //  评论数
    private Double score;       //  评分
    private Long scoreCount;     //  评分人数
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
