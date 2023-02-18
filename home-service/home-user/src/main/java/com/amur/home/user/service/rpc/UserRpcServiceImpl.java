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
import java.util.HashSet;
import java.util.Set;

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
        userEntity.setEmail(request.getEmail());
        userEntity.setPassword(request.getPassword());
        Set<String> permissions = new HashSet<>();
        permissions.add("user");
        userEntity.setPermissions(permissions);
        Long userId = userService.createUser(userEntity);
        if (userId == null) {
            response = response.toBuilder().setStatus(Status.FAILED).build();
        } else {
            response = response.toBuilder().setStatus(Status.SUCCESS).setUserId(userId).build();
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
            response = response.toBuilder().setStatus(Status.SUCCESS).build();
        } else {
            response = response.toBuilder().setStatus(Status.FAILED).build();
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
            response = response.toBuilder().setStatus(Status.SUCCESS).build();
        } else {
            response = response.toBuilder().setStatus(Status.FAILED).build();
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
            response = response.toBuilder().setStatus(Status.FAILED).build();
        } else {
            response = response.toBuilder().setStatus(Status.SUCCESS).setUserBase(UserBase.newBuilder().setName(userEntity.getName()).setAvatarUrl(userEntity.getAvatarUrl()).setRelativeTypeValue(userEntity.getRelativeType().getValue()).setPhone(userEntity.getPhone()).build()).build();
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
            response = response.toBuilder().setStatus(Status.FAILED).build();
        } else {
            response = response.toBuilder().setStatus(Status.SUCCESS).setUserDetail(UserDetail.newBuilder().setId(userEntity.getId()).setName(userEntity.getName()).setAvatarUrl(userEntity.getAvatarUrl()).setRelativeTypeValue(userEntity.getRelativeType().getValue()).setHomeId(userEntity.getHomeId()).setEmail(userEntity.getEmail()).setCreatedAt(userEntity.getCreateTime().toString()).setPhone(userEntity.getPhone()).setDescription(userEntity.getDescription()).build()).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUserAuthByName(GetUserAuthByNameRequest request, StreamObserver<GetUserAuthByNameResponse> responseObserver) {
        GetUserAuthByNameResponse response = GetUserAuthByNameResponse.newBuilder().build();
        UserEntity userEntity = userService.getUserByName(request.getUserName());
        if (userEntity == null) {
            response = response.toBuilder().setStatus(Status.FAILED).build();
        } else {
            response = response.toBuilder().setStatus(Status.SUCCESS).setUserId(userEntity.getId()).setUserName(userEntity.getName()).setPassword(userEntity.getPassword()).addAllPermissions(userEntity.getPermissions()).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getUserAuthById(GetUserAuthByIdRequest request, StreamObserver<GetUserAuthByIdResponse> responseObserver) {
        GetUserAuthByIdResponse response = GetUserAuthByIdResponse.newBuilder().build();
        UserEntity userEntity = userService.getUserInfo(request.getUserId());
        if (userEntity == null) {
            response = response.toBuilder().setStatus(Status.FAILED).build();
        } else {
            response = response.toBuilder().setStatus(Status.SUCCESS).setUserId(userEntity.getId()).setUserName(userEntity.getName()).setPassword(userEntity.getPassword()).addAllPermissions(userEntity.getPermissions()).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    @Deprecated
    public void getUserPermissionsByName(GetUserPermissionsByNameRequest request, StreamObserver<GetUserPermissionsByNameResponse> responseObserver) {
        GetUserPermissionsByNameResponse response = GetUserPermissionsByNameResponse.newBuilder().build();
        UserEntity userEntity = userService.getUserByName(request.getUserName());
        if (userEntity == null) {
            response = response.toBuilder().setStatus(Status.FAILED).build();
        } else {
            response = response.toBuilder().setStatus(Status.SUCCESS).setUserId(userEntity.getId()).setUserName(userEntity.getName()).addAllPermissions(userEntity.getPermissions()).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
