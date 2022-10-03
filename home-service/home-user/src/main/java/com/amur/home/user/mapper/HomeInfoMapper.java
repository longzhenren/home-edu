package com.amur.home.user.mapper;

import com.amur.home.user.entity.HomeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface HomeInfoMapper extends BaseMapper<HomeInfo> {
}
