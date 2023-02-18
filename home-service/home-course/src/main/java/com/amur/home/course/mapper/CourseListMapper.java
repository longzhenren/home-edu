package com.amur.home.course.mapper;

import com.amur.home.course.entity.CourseList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CourseListMapper extends BaseMapper<CourseList> {
}
