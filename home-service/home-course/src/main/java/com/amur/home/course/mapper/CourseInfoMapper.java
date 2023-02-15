package com.amur.home.course.mapper;

import com.amur.home.course.entity.CourseInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CourseInfoMapper extends BaseMapper<CourseInfoEntity> {
}
