package com.amur.home.user.service.rpc;

import com.amur.home.user.entity.UserEntity;
import com.amur.home.user.rpc.StatusOuterClass.Status;
import com.amur.home.user.rpc.User.*;
import com.amur.home.user.rpc.UserServiceGrpc;
import com.amur.home.user.service.impl.UserServiceImpl;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;

@GrpcService
@Slf4j
public class UserRpcServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Resource
    private UserServiceImpl userService;

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void createUser(CreateUserRequest request, StreamObserver<CreateUserResponse> responseObserver) {
        CreateUserResponse response = CreateUserResponse.newBuilder().build();
        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setPhone(request.getPhone());
        userEntity.setDescription(request.getDescription());
        Long userId = userService.createUser(userEntity);
        if (userId == null) {
            response.toBuilder().setStatus(Status.FAILED).build();
        } else {
            response.toBuilder().setStatus(Status.SUCCESS).setUserId(userId).build();
        }
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
        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setPhone(request.getPhone());
        userEntity.setDescription(request.getDescription());
        if (userService.updateUser(userEntity)) {
            response.toBuilder().setStatus(Status.SUCCESS).build();
        } else {
            response.toBuilder().setStatus(Status.FAILED).build();
        }
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
        if (userService.deleteUser(request.getUserId())) {
            response.toBuilder().setStatus(Status.SUCCESS).build();
        } else {
            response.toBuilder().setStatus(Status.FAILED).build();
        }
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
        UserEntity userEntity = userService.getUserInfo(request.getUserId());
        if (userEntity == null) {
            response.toBuilder().setStatus(Status.FAILED).build();
        } else {
            response.toBuilder().setStatus(Status.SUCCESS).setUserBase(UserBase.newBuilder()
                            .setName(userEntity.getName())
                            .setAvatarUrl(userEntity.getAvatarUrl())
                            .setRelativeTypeValue(userEntity.getRelativeType().getValue())
                            .setPhone(userEntity.getPhone())
                            .build())
                    .build();
        }
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
        UserEntity userEntity = userService.getUserInfo(request.getUserId());
        if (userEntity == null) {
            response.toBuilder().setStatus(Status.FAILED).build();
        } else {
            response.toBuilder().setStatus(Status.SUCCESS).setUserDetail(UserDetail.newBuilder()
                            .setId(userEntity.getId())
                            .setName(userEntity.getName())
                            .setAvatarUrl(userEntity.getAvatarUrl())
                            .setRelativeTypeValue(userEntity.getRelativeType().getValue())
                            .setHomeId(userEntity.getHomeId())
                            .setEmail(userEntity.getEmail())
                            .setCreatedAt(userEntity.getCreateTime().toString())
                            .setPhone(userEntity.getPhone())
                            .setDescription(userEntity.getDescription())
                            .build())
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
