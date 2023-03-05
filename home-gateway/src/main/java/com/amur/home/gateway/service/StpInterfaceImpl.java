package com.amur.home.gateway.service;

import cn.dev33.satoken.stp.StpInterface;
import com.amur.home.auth.entity.UserAuth;
import com.amur.home.gateway.client.GatewayGrpcClient;
import com.amur.home.gateway.utils.RedisUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private GatewayGrpcClient gatewayGrpcClient;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的权限列表
        UserAuth userAuth = null;
        if (redisUtils.exists("user_auth:" + loginId)) {
            userAuth = (UserAuth) redisUtils.get("user_auth:" + loginId);
        } else {
            userAuth = gatewayGrpcClient.getUserAuthById((Long) loginId);
            redisUtils.set("user_auth:" + loginId, userAuth);
        }
        List<String> list = new ArrayList<>(userAuth.getPermissions());
        return list;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的角色列表
        UserAuth userAuth = null;
        if (redisUtils.exists("user_auth:" + loginId)) {
            userAuth = (UserAuth) redisUtils.get("user_auth:" + loginId);
        } else {
            userAuth = gatewayGrpcClient.getUserAuthById((Long) loginId);
            redisUtils.set("user_auth:" + loginId, userAuth);
        }
        List<String> list = new ArrayList<>(userAuth.getRoles());
        return list;
    }

}
