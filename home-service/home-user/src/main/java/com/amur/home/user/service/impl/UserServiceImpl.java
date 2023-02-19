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
     * 根据用户 ID 获取用户信息。
     *
     * @param userId 用户 ID。
     * @return 用户实体对象。
     */
    @Override
    public UserEntity getUserInfo(Long userId) {
        return userMapper.selectById(userId);
    }

    /**
     * 更新用户信息。
     *
     * @param userEntity 用户实体对象。
     * @return 如果更新成功，返回 true；否则，返回 false。
     */
    @Override
    public boolean updateUser(UserEntity userEntity) {
        return userMapper.updateById(userEntity) > 0;
    }

    /**
     * 删除用户。
     *
     * @param userId 用户 ID。
     * @return 如果删除成功，返回 true；否则，返回 false。
     */
    @Override
    public boolean deleteUser(Long userId) {
        return userMapper.deleteById(userId) > 0;
    }

    /**
     * 创建用户。
     *
     * @param userEntity 用户实体对象。
     * @return 新创建的用户的 ID。
     */
    @Override
    public Long createUser(UserEntity userEntity) {
        userMapper.insert(userEntity);
        return userEntity.getId();
    }

    /**
     * 根据用户名获取用户信息。
     *
     * @param username 用户名。
     * @return 用户实体对象。
     */
    @Override
    public UserEntity getUserByName(String username) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", username);
        return userMapper.selectOne(queryWrapper);
    }

    /**
     * 更新用户密码。
     *
     * @param userId      用户 ID。
     * @param oldPassword 旧密码。
     * @param newPassword 新密码。
     * @return 如果更新成功，返回 true；否则，返回 false。
     */
    @Override
    public boolean updatePassword(Long userId, String oldPassword, String newPassword) {
        UserEntity userEntity = userMapper.selectById(userId);
        if (userEntity == null) {
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
