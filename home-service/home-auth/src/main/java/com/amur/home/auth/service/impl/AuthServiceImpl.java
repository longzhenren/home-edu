package com.amur.home.auth.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.amur.home.auth.client.UserGrpcClient;
import com.amur.home.auth.entity.UserAuth;
import com.amur.home.auth.mapper.AuthMapper;
import com.amur.home.auth.service.AuthService;
import com.amur.home.auth.util.RedisUtils;
import com.amur.home.common.Constants;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.util.ServiceResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    private UserGrpcClient userGrpcClient;

    @Resource
    private AuthMapper authMapper;

    @Resource
    private RedisUtils redisUtils;

    /**
     * @param userName 用户名
     * @param password 密码
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Map<String, Object>> login(String userName, String password) {
        QueryWrapper<UserAuth> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", userName);
        UserAuth userAuth = authMapper.selectOne(queryWrapper);
        if (userAuth == null) {
            return ServiceResult.fail("用户不存在");
        }
        if (!new BCryptPasswordEncoder().matches(password, userAuth.getPassword())) {
            return ServiceResult.fail("密码不正确");
        }
        ServiceResult<UserInfo> res = userGrpcClient.getUserEntityByUserId(userAuth.getId());
        UserInfo user = res.getData();
        redisUtils.set("user_info:" + user.getId(), user);
        redisUtils.set("user_auth:" + userAuth.getId(), userAuth);
        StpUtil.login(user.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("token", StpUtil.getTokenInfo());
        map.put("user", user);
        return ServiceResult.success(map);
    }

    /**
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> logout() {
        StpUtil.logout();
        redisUtils.remove("user_info:" + StpUtil.getLoginId());
        redisUtils.remove("user_auth:" + StpUtil.getLoginId());
        return ServiceResult.success();
    }

    /**
     * @param userName 用户名
     * @param password 密码
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Long> register(String userName, String password) {
        QueryWrapper<UserAuth> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", userName);
        if (authMapper.selectOne(queryWrapper) != null) {
            return ServiceResult.fail("用户名已被使用");
        }
        ServiceResult<Long> res = userGrpcClient.createUser(userName);
        if (!res.isSuccess()) {
            return ServiceResult.fail(res.getMessage());
        }
        Long userId = res.getData();
        UserAuth userAuth = new UserAuth();
        userAuth.setId(userId);
        userAuth.setPassword(new BCryptPasswordEncoder().encode(password));
        userAuth.setRoles(Collections.singleton(Constants.RoleName.USER.getName()));
        userAuth.setPermissions(Collections.singleton(Constants.PermissionName.USER.getName()));
        if (authMapper.insert(userAuth) > 0) {
            return ServiceResult.success(userId);
        } else {
            userGrpcClient.deleteUser(userId);
            return ServiceResult.fail("注册失败");
        }
    }

    /**
     * @param id 用户ID
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<UserAuth> getUserAuthById(Long id) {
        UserAuth userAuth = authMapper.selectById(id);
        if (userAuth == null) {
            return ServiceResult.fail("用户不存在");
        }
        return ServiceResult.success(userAuth);
    }

    /**
     * @param id         用户ID
     * @param permission 权限
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> addPermission(Long id, String permission) {
        UserAuth userAuth = authMapper.selectById(id);
        if (userAuth == null) {
            return ServiceResult.fail("用户不存在");
        }
        if (userAuth.getPermissions().contains(permission)) {
            return ServiceResult.fail("用户已有该权限");
        }
        userAuth.getPermissions().add(permission);
        if (authMapper.updateById(userAuth) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("添加权限失败");
        }
    }

    /**
     * @param id         用户ID
     * @param permission 权限
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> removePermission(Long id, String permission) {
        UserAuth userAuth = authMapper.selectById(id);
        if (userAuth == null) {
            return ServiceResult.fail("用户不存在");
        }
        if (!userAuth.getPermissions().contains(permission)) {
            return ServiceResult.fail("用户没有该权限");
        }
        userAuth.getPermissions().remove(permission);
        if (authMapper.updateById(userAuth) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("删除权限失败");
        }
    }

    /**
     * @param id   用户ID
     * @param role 角色
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> addRole(Long id, String role) {
        UserAuth userAuth = authMapper.selectById(id);
        if (userAuth == null) {
            return ServiceResult.fail("用户不存在");
        }
        if (userAuth.getRoles().contains(role)) {
            return ServiceResult.fail("用户已有该角色");
        }
        userAuth.getRoles().add(role);
        if (authMapper.updateById(userAuth) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("添加角色失败");
        }
    }

    /**
     * @param id   用户ID
     * @param role 角色
     * @return 服务返回结果统一封装
     */
    @Override
    public ServiceResult<Void> removeRole(Long id, String role) {
        UserAuth userAuth = authMapper.selectById(id);
        if (userAuth == null) {
            return ServiceResult.fail("用户不存在");
        }
        if (!userAuth.getRoles().contains(role)) {
            return ServiceResult.fail("用户没有该角色");
        }
        userAuth.getRoles().remove(role);
        if (authMapper.updateById(userAuth) > 0) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail("删除角色失败");
        }
    }
}
