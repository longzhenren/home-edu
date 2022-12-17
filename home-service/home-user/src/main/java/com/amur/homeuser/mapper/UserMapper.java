package com.amur.homeuser.mapper;

import com.amur.homeuser.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component(value ="userMapper")
@Repository
public interface UserMapper extends BaseMapper<UserEntity>{
    UserEntity getUserById(Long id);
}
