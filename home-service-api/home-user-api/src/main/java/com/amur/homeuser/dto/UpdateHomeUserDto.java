package com.amur.homeuser.dto;

import lombok.Data;

import java.util.List;
@Data
public class UpdateHomeUserDto {
    String homeId;
    List<String> userIds;
}
