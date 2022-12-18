package com.amur.homeuser.service.impl;

import com.amur.homeuser.entity.UserEntity;
import com.amur.homeuser.mapper.UserMapper;
import com.amur.homeuser.service.UserService;
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
