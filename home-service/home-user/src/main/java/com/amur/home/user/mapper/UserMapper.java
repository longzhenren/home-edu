package com.amur.home.user.mapper;

import com.amur.home.user.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserEntity> {
    UserEntity getUser(String name, String password);
}
