package com.amur.home.user.mapper;

import com.amur.home.user.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component(value ="userMapper")
@Repository
public interface UserMapper extends BaseMapper<UserEntity>{
}
