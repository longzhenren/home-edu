package com.amur.homeuser.mapper;

import com.amur.homeuser.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

@Component(value ="userMapper")
public interface UserMapper extends BaseMapper<UserEntity>{
    UserEntity getUserById(Long id);
}
