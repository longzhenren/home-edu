package com.amur.home.course.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("course_info")
public class CourseInfoEntity {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private Long listId;
    private String title;
    private String description;
    private Long homeId;
    private String coverUrl;
    private String teacherIds;
    private String studentIds;  //  听课人员
    private String courseWareIds;   //  课件
    private Long commentIds;
    private String status;      //  课程状态
    private String startTime;   //  开始时间
    private String endTime;     //  结束时间
    private boolean open;       // 课程是否公开
    private Long likeCount;     //  点赞数
    private Long favCount;      //  收藏数
    private Long commentCount;  //  评论数
    private Double score;       //  评分
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
