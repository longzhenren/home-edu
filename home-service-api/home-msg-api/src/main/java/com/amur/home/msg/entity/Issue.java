package com.amur.home.msg.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@TableName(value = "issue_info", autoResultMap = true)
public class Issue {
    @TableId
    private Long id;
    private Long homeId;
    private Long userId;
    private String title;
    private String content;
    private Long replyCount;
    private Long likeCount;
    private Long viewCount;
    private Long status;
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

    public Issue(Long id, Long homeId, Long userId, String title, String content) {
        this.id = id;
        this.homeId = homeId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.replyCount = 0L;
        this.likeCount = 0L;
        this.viewCount = 0L;
        this.status = 0L;
    }
}
