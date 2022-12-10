package com.amur.homeuser.service.impl;

import com.amur.homeuser.rpc.HomeUserServiceGrpc;
import com.amur.homeuser.rpc.User.*;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserRpcServiceImpl extends HomeUserServiceGrpc.HomeUserServiceImplBase {
    @Override
    public void getHomeUser(HomeUserRequest request, io.grpc.stub.StreamObserver<HomeUserResponse> responseObserver) {
        HomeUserResponse response = HomeUserResponse.newBuilder()
                .setId(request.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
