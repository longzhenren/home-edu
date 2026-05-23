package com.amur.home.ai.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("ai_message")
public class AiMessage {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("conversation_id")
    private Long conversationId;
    private Integer sender;
    private String content;
    @TableField("model_used")
    private String modelUsed;
    @TableField("token_count")
    private Integer tokenCount;
    @TableField("response_time_ms")
    private Long responseTimeMs;
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    @TableLogic
    private Boolean deleted;
}
