package com.amur.homeuser.mapper;

import com.amur.homeuser.entity.HomeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component(value ="homeMapper")
public interface HomeMapper extends BaseMapper<HomeEntity> {

    HomeEntity getHomeById(Long id);


}
