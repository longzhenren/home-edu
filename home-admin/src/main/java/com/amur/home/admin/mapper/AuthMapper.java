package com.amur.home.admin.mapper;

import com.amur.home.auth.entity.UserAuth;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface AuthMapper extends BaseMapper<UserAuth> {
}
