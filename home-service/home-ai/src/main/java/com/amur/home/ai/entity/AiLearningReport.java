package com.amur.home.ai.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("ai_learning_report")
public class AiLearningReport {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    @TableField("report_type")
    private String reportType;
    @TableField("knowledge_weakness")
    private String knowledgeWeakness;
    @TableField("learning_trend")
    private String learningTrend;
    @TableField("recommendations")
    private String recommendations;
    @TableField("generated_time")
    private LocalDateTime generatedTime;
    @TableLogic
    private Boolean deleted;
}
