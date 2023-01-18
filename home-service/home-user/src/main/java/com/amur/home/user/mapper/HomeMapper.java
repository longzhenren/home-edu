package com.amur.home.user.mapper;

import com.amur.home.user.entity.HomeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Component(value ="homeMapper")
@Repository
@Mapper
public interface HomeMapper extends BaseMapper<HomeEntity> {
}
