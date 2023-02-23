package com.amur.home.auth.client;

import com.amur.home.user.converter.UserProtoConverter;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.rpc.ServiceResultProto;
import com.amur.home.user.rpc.UserServiceGrpc;
import com.amur.home.user.rpc.UserServiceProto;
import com.amur.home.util.ServiceResult;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class UserGrpcClient {
    @GrpcClient("home-user")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public ServiceResult<UserInfo> getUserEntityByUserName(String username) {
        UserServiceProto.UserNameRequest userNameRequest = UserServiceProto.UserNameRequest.newBuilder().setUserName(username).build();
        UserServiceProto.UserInfoResponse resp = userServiceBlockingStub.getUserByName(userNameRequest);
        if (resp.getResult().getSuccess()) {
            UserServiceProto.UserInfo userInfoProto = resp.getUserInfo();
            return ServiceResult.success(UserProtoConverter.toUserInfo(userInfoProto));
        } else {
            return ServiceResult.fail(resp.getResult().getMessage());
        }
    }

    public ServiceResult<Long> createUser(String userName) {
        UserServiceProto.CreateUserRequest createUserRequest = UserServiceProto.CreateUserRequest.newBuilder().setUserName(userName).build();
        UserServiceProto.UserIdResponse resp = userServiceBlockingStub.createUser(createUserRequest);
        if (resp.getResult().getSuccess()) {
            return ServiceResult.success(resp.getUserId());
        } else {
            return ServiceResult.fail(resp.getResult().getMessage());
        }
    }

    public ServiceResult<Void> deleteUser(Long userId) {
        UserServiceProto.UserIdRequest userIdRequest = UserServiceProto.UserIdRequest.newBuilder().setUserId(userId).build();
        ServiceResultProto.ServiceResult resp = userServiceBlockingStub.deleteUser(userIdRequest);
        if (resp.getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail(resp.getMessage());
        }
    }
}
