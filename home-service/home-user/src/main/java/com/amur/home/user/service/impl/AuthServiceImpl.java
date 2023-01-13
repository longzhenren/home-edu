package com.amur.home.user.service.impl;

import com.amur.home.user.entity.AuthEntity;
import com.amur.home.user.entity.UserEntity;
import com.amur.home.user.mapper.RoleMapper;
import com.amur.home.user.mapper.UserMapper;
import com.amur.home.user.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.tool.utils.Func;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;

    @Override
    public AuthEntity getAuthInfo(String username, String password) {
        AuthEntity authEntity = new AuthEntity();
        UserEntity user = userMapper.getUser(username, password);
        authEntity.setUser(user);
        if (Func.isNotEmpty(user)) {
            authEntity.setRoles(Func.toStrList(roleMapper.selectById(user.getRoleId()).getName()));
        }
        return authEntity;
    }
    @Override
    public AuthEntity getAuthInfo(long userId) {
        AuthEntity authEntity = new AuthEntity();
        UserEntity user = userMapper.selectById(userId);
        authEntity.setUser(user);
        if (Func.isNotEmpty(user)) {
            authEntity.setRoles(Func.toStrList(roleMapper.selectById(user.getRoleId()).getName()));
        }
        return authEntity;
    }
}
