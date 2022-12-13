package com.amur.homeuser.service.impl;

import com.amur.homeuser.rpc.User.*;
import com.amur.homeuser.rpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class UserRpcServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void createUser(CreateUserRequest request, StreamObserver<CreateUserResponse> responseObserver) {
        CreateUserResponse response = CreateUserResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void updateUser(UpdateUserRequest request, StreamObserver<UpdateUserResponse> responseObserver) {
        UpdateUserResponse response = UpdateUserResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void deleteUser(DeleteUserRequest request, StreamObserver<DeleteUserResponse> responseObserver) {
        DeleteUserResponse response = DeleteUserResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getUserBaseInfo(GetUserBaseRequest request, StreamObserver<GetUserBaseResponse> responseObserver) {
        GetUserBaseResponse response = GetUserBaseResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getUserDetailInfo(GetUserDetailRequest request, StreamObserver<GetUserDetailResponse> responseObserver) {
        GetUserDetailResponse response = GetUserDetailResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
