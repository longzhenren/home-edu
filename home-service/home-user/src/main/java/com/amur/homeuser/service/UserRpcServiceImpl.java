package com.amur.homeuser.service;

import com.amur.homeuser.api.HomeUserServiceGrpc;
import com.amur.homeuser.api.User;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService(com.amur.homeuser.api.User.class)
public class UserRpcServiceImpl extends HomeUserServiceGrpc.HomeUserServiceImplBase {
    @Override
    public void getHomeUser(User.HomeUserRequest request,
            io.grpc.stub.StreamObserver<User.HomeUserResponse> responseObserver) {
        User.HomeUserResponse response = User.HomeUserResponse.newBuilder()
                .setId(request.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
