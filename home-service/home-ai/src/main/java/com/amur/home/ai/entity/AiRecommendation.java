package com.amur.home.ai.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("ai_recommendation")
public class AiRecommendation {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    @TableField("target_type")
    private String targetType;
    @TableField("target_id")
    private Long targetId;
    private String reason;
    private Integer status;
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;
    @TableLogic
    private Boolean deleted;
}
