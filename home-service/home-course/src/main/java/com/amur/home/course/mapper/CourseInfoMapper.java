package com.amur.home.course.mapper;

import com.amur.home.course.entity.CourseInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface CourseInfoMapper extends BaseMapper<CourseInfo> {
}
