package com.amur.home.auth.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.amur.home.auth.client.UserGrpcClient;
import com.amur.home.auth.entity.UserAuth;
import com.amur.home.auth.mapper.AuthMapper;
import com.amur.home.auth.service.AuthService;
import com.amur.home.auth.util.RedisUtils;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.util.ServiceResult;
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
     * @param userName
     * @param password
     * @return
     */
    @Override
    public ServiceResult<Map<String, Object>> login(String userName, String password) {
        ServiceResult<UserInfo> res = userGrpcClient.getUserEntityByUserName(userName);
        if (!res.isSuccess()) {
            return ServiceResult.fail(res.getMessage());
        }
        UserInfo user = res.getData();
        UserAuth userAuth = authMapper.selectById(user.getId());
        if (!new BCryptPasswordEncoder().matches(password, userAuth.getPassword())) {
            return ServiceResult.fail("密码不正确");
        }
        redisUtils.set("user_info:" + user.getId(), user);
        redisUtils.set("user_auth:" + StpUtil.getLoginId(), userAuth);
        StpUtil.login(user.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("token", StpUtil.getTokenInfo());
        map.put("user", user);
        return ServiceResult.success(map);
    }

    /**
     * @return
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
     * @return 用户ID
     */
    @Override
    public ServiceResult<Long> register(String userName, String password) {
        if (userGrpcClient.getUserEntityByUserName(userName).isSuccess()) {
            return ServiceResult.fail("用户已存在");
        }
        ServiceResult<Long> res = userGrpcClient.createUser(userName);
        if (!res.isSuccess()) {
            return ServiceResult.fail(res.getMessage());
        }
        Long userId = res.getData();
        UserAuth userAuth = new UserAuth();
        userAuth.setId(userId);
        userAuth.setPassword(new BCryptPasswordEncoder().encode(password));
        userAuth.setRoles(Collections.singleton("user"));
        if (authMapper.insert(userAuth) > 0) {
            return ServiceResult.success(userId);
        } else {
            userGrpcClient.deleteUser(userId);
            return ServiceResult.fail("注册失败");
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public ServiceResult<UserAuth> getUserAuthById(Long id) {
        UserAuth userAuth = authMapper.selectById(id);
        if (userAuth == null) {
            return ServiceResult.fail("用户不存在");
        }
        return ServiceResult.success(userAuth);
    }
}
