package com.amur.home.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user_unity", autoResultMap = true)
public class UserUnity {
    @TableId
    private Long id;
    private Long modelId;
    private String text;

    public UserUnity(Long id) {
        this.id = id;
        this.modelId = 0L;
        this.text = "";
    }
}
