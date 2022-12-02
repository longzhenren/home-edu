package com.amur.home.msg.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "issue_reply", autoResultMap = true)
public class IssueReply {
    @TableId
    private Long id;
    private Long issueId;
    private Long userId;
    private String content;
    private Long likeCount;
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

    public IssueReply(Long id, Long issueId, Long userId, String content) {
        this.id = id;
        this.issueId = issueId;
        this.userId = userId;
        this.content = content;
        this.likeCount = 0L;
    }
}
