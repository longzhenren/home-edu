package com.amur.home.auth.client;

import com.amur.home.common.constant.Constants;
import com.amur.home.core.tool.utils.DigestUtil;
import com.amur.home.core.tool.utils.Func;
import com.amur.home.user.entity.AuthEntity;
import com.amur.home.user.entity.UserEntity;
import com.amur.home.user.rpc.Auth;
import com.amur.home.user.rpc.AuthServiceGrpc;
import com.amur.home.user.rpc.StatusOuterClass;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class AuthGrpcClient {
    @GrpcClient("home-user")
    private AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub;

    public AuthEntity getAuthEntity(long userId) {
        Auth.GetAuthEntityByUserIdReq getAuthEntityRequest = Auth.GetAuthEntityByUserIdReq.newBuilder().setUserId(userId).build();
        Auth.GetAuthEntityResp resp = authServiceBlockingStub.getAuthEntityByUserId(getAuthEntityRequest);
        return buildAuthEntity(resp);
    }

    public AuthEntity getAuthEntity(String username, String password) {
        Auth.GetAuthEntityReq getAuthEntityRequest = Auth.GetAuthEntityReq.newBuilder().setUsername(username).setPassword(DigestUtil.encrypt(password)).build();
        Auth.GetAuthEntityResp resp = authServiceBlockingStub.getAuthEntity(getAuthEntityRequest);
        return buildAuthEntity(resp);
    }

    private AuthEntity buildAuthEntity(Auth.GetAuthEntityResp resp) {
        if (resp.getStatus().equals(StatusOuterClass.Status.SUCCESS)) {
            UserEntity user = new UserEntity();
            Auth.UserAuth userAuth = resp.getUser();
            user.setName(userAuth.getName());
            user.setPassword(userAuth.getPassword());
            user.setEmail(userAuth.getEmail());
            user.setAvatarUrl(userAuth.getAvatarUrl());
            user.setPhone(userAuth.getPhone());
            user.setId(userAuth.getId());
            user.setHomeId(userAuth.getHomeId());
            user.setRoleId(userAuth.getRoleId());
            user.setDescription(userAuth.getDescription());
            user.setCreateTime(Func.parseDate(userAuth.getCreatedAt(), "yyyy-MM-dd HH:mm:ss"));
            user.setRelativeType(Constants.UserRelativeType.valueOf(userAuth.getRelativeType().name()));
            AuthEntity authEntity = new AuthEntity();
            authEntity.setUser(user);
            authEntity.setRoles(resp.getRolesList());
            authEntity.setPermissions(resp.getPermissionsList());
            return authEntity;
        }
        return null;
    }
}
