package com.amur.homeuser.service.impl;

import com.amur.homeuser.rpc.User.*;
import com.amur.homeuser.rpc.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserRpcServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void createUser(CreateUserRequest request, StreamObserver<CreateUserResponse> responseObserver) {
        super.createUser(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void updateUser(UpdateUserRequest request, StreamObserver<UpdateUserResponse> responseObserver) {
        super.updateUser(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void deleteUser(DeleteUserRequest request, StreamObserver<DeleteUserResponse> responseObserver) {
        super.deleteUser(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getUserBaseInfo(GetUserBaseRequest request, StreamObserver<GetUserBaseResponse> responseObserver) {
        super.getUserBaseInfo(request, responseObserver);
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getUserDetailInfo(GetUserDetailRequest request, StreamObserver<GetUserDetailResponse> responseObserver) {
        super.getUserDetailInfo(request, responseObserver);
    }
}
