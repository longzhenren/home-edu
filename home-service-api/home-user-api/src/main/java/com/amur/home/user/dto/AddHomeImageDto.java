package com.amur.home.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Schema(title = "添加图片")
@NoArgsConstructor
@AllArgsConstructor
public class AddHomeImageDto {
    private Long homeId;
    private List<String> imageUrl;

}
