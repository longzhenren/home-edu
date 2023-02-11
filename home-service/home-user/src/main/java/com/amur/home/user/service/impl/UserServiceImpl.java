package com.amur.home.user.service.impl;

import com.amur.home.user.entity.UserEntity;
import com.amur.home.user.mapper.UserMapper;
import com.amur.home.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Override
    public UserEntity getUserByName(String username) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean updatePassword(Long userId, String oldPassword, String newPassword) {
        UserEntity userEntity = userMapper.selectById(userId);
        if(userEntity == null) {
            return false;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(oldPassword, userEntity.getPassword())) {
            userEntity.setPassword(encoder.encode(newPassword));
            return userMapper.updateById(userEntity) > 0;
        }
        return false;
    }
}
