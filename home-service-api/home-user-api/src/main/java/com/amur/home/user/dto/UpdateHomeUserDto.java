package com.amur.home.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
@Schema
@Data
public class UpdateHomeUserDto {
    String homeId;
    List<String> userIds;
}
