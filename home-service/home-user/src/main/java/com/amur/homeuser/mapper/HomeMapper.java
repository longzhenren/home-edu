package com.amur.homeuser.mapper;

import com.amur.homeuser.entity.HomeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component(value ="homeMapper")
@Repository
public interface HomeMapper extends BaseMapper<HomeEntity> {
}
