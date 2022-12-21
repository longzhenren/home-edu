package com.amur.home.user.dto;

import lombok.Data;

import java.util.List;
@Data
public class UpdateHomeUserDto {
    String homeId;
    List<String> userIds;
}
