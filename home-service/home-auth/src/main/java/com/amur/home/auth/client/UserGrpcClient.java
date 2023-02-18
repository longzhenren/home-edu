package com.amur.home.auth.client;

import com.amur.home.user.entity.UserEntity;
import com.amur.home.user.rpc.StatusOuterClass;
import com.amur.home.user.rpc.User;
import com.amur.home.user.rpc.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class UserGrpcClient {
    @GrpcClient("home-user")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public UserEntity getUserEntityByUserName(String username) {
        User.GetUserAuthByNameRequest getUserAuthByNameRequest = User.GetUserAuthByNameRequest.newBuilder().setUserName(username).build();
        User.GetUserAuthByNameResponse resp = userServiceBlockingStub.getUserAuthByName(getUserAuthByNameRequest);
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

    public void createUser(String username, String password) {
        User.CreateUserRequest createUserRequest = User.CreateUserRequest.newBuilder().setName(username).setPassword(new BCryptPasswordEncoder().encode(password)).build();
        User.CreateUserResponse resp = userServiceBlockingStub.createUser(createUserRequest);
    }
}
