package com.amur.home.msg.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "issue_info", autoResultMap = true)
public class Issue {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private Long homeId;
    private Long userId;
    private String title;
    private String content;
    private String reply;
    private String replyUserId;
    private String replyTime;
    private Long likeCount;
    private Long commentCount;
    private Long viewCount;
    private Long status;
}
