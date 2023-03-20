package com.amur.home.course.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCourseInterDTO {
    Boolean isFavorite;
    Boolean isJoin;
    Boolean isLike;
    Boolean isScore;
    Boolean isComment;
    Double Score;
}
