package com.amur.home.gateway.client;

import com.amur.home.auth.converter.AuthProtoConverter;
import com.amur.home.auth.entity.UserAuth;
import com.amur.home.auth.rpc.AuthServiceGrpc;
import com.amur.home.auth.rpc.AuthServiceProto;
import com.amur.home.user.converter.UserProtoConverter;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.rpc.UserServiceGrpc;
import com.amur.home.user.rpc.UserServiceProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
public class GatewayGrpcClient {
    @GrpcClient("home-user")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @GrpcClient("home-auth")
    private AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub;

    public UserInfo getUserEntityByUserName(String username) {
        UserServiceProto.UserNameRequest userNameRequest = UserServiceProto.UserNameRequest.newBuilder().setUserName(username).build();
        UserServiceProto.UserInfoResponse resp = userServiceBlockingStub.getUserByName(userNameRequest);
        UserServiceProto.UserInfo userInfoProto = resp.getUserInfo();
        return UserProtoConverter.toUserInfo(userInfoProto);
    }

    public UserAuth getUserAuthById(Long userId) {
        AuthServiceProto.GetAuthByIdRequest authIdRequest = AuthServiceProto.GetAuthByIdRequest.newBuilder().setId(userId).build();
        AuthServiceProto.GetAuthByIdResponse resp = authServiceBlockingStub.getAuthById(authIdRequest);
        AuthServiceProto.UserAuth userAuthProto = resp.getAuth();
        return AuthProtoConverter.toUserAuth(userAuthProto);
    }


}
