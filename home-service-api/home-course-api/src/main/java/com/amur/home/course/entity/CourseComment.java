package com.amur.home.course.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("course_comment")
public class CourseComment {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private Long courseId;
    private Long userId;
    private String content;
    private String reply;
    private String replyUserId;
    private String replyTime;
    private Long likeCount;
    private Double score;
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
