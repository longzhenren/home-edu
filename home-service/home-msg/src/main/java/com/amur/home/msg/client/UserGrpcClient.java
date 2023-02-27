package com.amur.home.msg.client;

import com.amur.home.user.rpc.UserServiceGrpc;
import com.amur.home.user.rpc.UserServiceProto;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserGrpcClient {
    @GrpcClient("home-user")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public boolean checkUserExists(Long userId) {
        UserServiceProto.UserIdRequest request = UserServiceProto.UserIdRequest.newBuilder().setUserId(userId).build();
        UserServiceProto.CheckUserExistsResponse response = userServiceBlockingStub.checkUserExists(request);
        return response.getExists();
    }
}
