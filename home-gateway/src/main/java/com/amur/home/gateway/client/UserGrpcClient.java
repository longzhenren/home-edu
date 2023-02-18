package com.amur.home.gateway.client;

import com.amur.home.user.entity.UserEntity;
import com.amur.home.user.rpc.StatusOuterClass;
import com.amur.home.user.rpc.User;
import com.amur.home.user.rpc.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class UserGrpcClient {
    @GrpcClient("home-user")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public UserEntity getUserEntityByUserName(Long userId) {
        User.GetUserAuthByIdRequest getUserAuthByNameRequest = User.GetUserAuthByIdRequest.newBuilder().setUserId(userId).build();
        User.GetUserAuthByIdResponse resp = userServiceBlockingStub.getUserAuthById(getUserAuthByNameRequest);
        if (resp.getStatus().equals(StatusOuterClass.Status.SUCCESS)) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId(resp.getUserId());
            userEntity.setName(resp.getUserName());
            userEntity.setPassword(resp.getPassword());
            userEntity.setPermissions(new HashSet<>(resp.getPermissionsList()));
            return userEntity;
        } else {
            return null;
        }
    }
}
