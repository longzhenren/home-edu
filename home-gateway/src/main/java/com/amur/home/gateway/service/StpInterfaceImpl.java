package com.amur.home.gateway.service;

import cn.dev33.satoken.stp.StpInterface;
import com.amur.home.gateway.client.UserGrpcClient;
import com.amur.home.gateway.utils.RedisUtils;
import com.amur.home.user.entity.UserEntity;
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
    private UserGrpcClient userGrpcClient;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的权限列表
        UserEntity userEntity;
        if (redisUtils.exists("user:" + loginId)) {
            userEntity = (UserEntity) redisUtils.get("user:" + loginId);
        } else {
            userEntity = userGrpcClient.getUserEntityByUserName(Long.parseLong((String) loginId));
            redisUtils.set("user:" + loginId, userEntity);
        }
        return new ArrayList<>(userEntity.getPermissions());
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的角色列表
        return null;
    }

}
