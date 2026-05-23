package com.amur.home.ai.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("ai_conversation")
public class AiConversation {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    @TableField("role_type")
    private Integer roleType;
    @TableField("session_id")
    private String sessionId;
    @TableField("module_type")
    private String moduleType;
    @TableField("title")
    private String title;
    @TableField("last_message")
    private String lastMessage;
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    @TableField(value = "updated_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;
    @TableLogic
    private Boolean deleted;
}
