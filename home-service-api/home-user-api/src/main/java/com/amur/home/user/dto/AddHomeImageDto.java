package com.amur.home.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddHomeImageDto {
    private Long homeId;
    private List<String> imageUrl;

}
