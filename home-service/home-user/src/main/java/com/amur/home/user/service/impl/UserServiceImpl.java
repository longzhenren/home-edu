package com.amur.home.user.service.impl;

import com.amur.home.user.entity.UserEntity;
import com.amur.home.user.mapper.UserMapper;
import com.amur.home.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * @param userId
     * @return
     */
    @Override
    public UserEntity getUserInfo(Long userId) {
        return userMapper.selectById(userId);
    }

    /**
     * @param userEntity
     * @return
     */
    @Override
    public boolean updateUser(UserEntity userEntity) {
        return userMapper.updateById(userEntity) > 0;
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public boolean deleteUser(Long userId) {
        return userMapper.deleteById(userId) > 0;
    }

    /**
     * @param userEntity
     * @return
     */
    @Override
    public Long createUser(UserEntity userEntity) {
        userMapper.insert(userEntity);
        return userEntity.getId();
    }
}
