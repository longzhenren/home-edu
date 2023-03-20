package com.amur.home.user.service.rpc;

import com.amur.home.common.Constants;
import com.amur.home.user.converter.ServiceResultProtoConverter;
import com.amur.home.user.converter.UserProtoConverter;
import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.rpc.ServiceResultProto;
import com.amur.home.user.rpc.UserServiceGrpc;
import com.amur.home.user.rpc.UserServiceProto;
import com.amur.home.user.service.impl.UserServiceImpl;
import com.amur.home.util.ServiceResult;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;

@GrpcService
@Slf4j
public class UserRpcServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Resource
    private UserServiceImpl userService;


    @Override
    public void getUserInfo(UserServiceProto.UserIdRequest request, StreamObserver<UserServiceProto.UserInfoResponse> responseObserver) {
        ServiceResult<UserInfo> res = userService.getUserInfo(request.getUserId());
        if (!res.isSuccess()) {
            UserServiceProto.UserInfoResponse response = UserServiceProto.UserInfoResponse.newBuilder().setResult(ServiceResultProtoConverter.toServiceResultProto(res)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        UserServiceProto.UserInfo userInfoProto = UserProtoConverter.toUserInfoProto(res.getData());
        UserServiceProto.UserInfoResponse response = UserServiceProto.UserInfoResponse.newBuilder().setUserInfo(userInfoProto).setResult(ServiceResultProtoConverter.toServiceResultProto(res)).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void updateUser(UserServiceProto.UserInfoRequest request, StreamObserver<ServiceResultProto.ServiceResult> responseObserver) {
        UserServiceProto.UserInfo userInfoProto = request.getUserInfo();
        ServiceResult<Void> res = userService.updateUser(userInfoProto.getId(), userInfoProto.getDescription(), userInfoProto.getPhone(), userInfoProto.getEmail(), userInfoProto.getAvatarUrl(), userInfoProto.getSex(), userInfoProto.getAge(), Constants.UserRelativeType.valueOf(userInfoProto.getRelativeTypeValue()));
        if (!res.isSuccess()) {
            ServiceResultProto.ServiceResult resProto = ServiceResultProtoConverter.toServiceResultProto(res);
            responseObserver.onNext(resProto);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult resProto = ServiceResultProtoConverter.toServiceResultProto(res);
        responseObserver.onNext(resProto);
        responseObserver.onCompleted();
    }


    @Override
    public void deleteUser(UserServiceProto.UserIdRequest request, StreamObserver<ServiceResultProto.ServiceResult> responseObserver) {
        ServiceResult<Void> res = userService.deleteUser(request.getUserId());
        if (!res.isSuccess()) {
            ServiceResultProto.ServiceResult resProto = ServiceResultProtoConverter.toServiceResultProto(res);
            responseObserver.onNext(resProto);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult resProto = ServiceResultProtoConverter.toServiceResultProto(res);
        responseObserver.onNext(resProto);
        responseObserver.onCompleted();
    }


    @Override
    public void createUser(UserServiceProto.CreateUserRequest request, StreamObserver<UserServiceProto.UserIdResponse> responseObserver) {
        ServiceResult<Long> res = userService.createUser(request.getUserName());
        if (!res.isSuccess()) {
            UserServiceProto.UserIdResponse response = UserServiceProto.UserIdResponse.newBuilder().setResult(ServiceResultProtoConverter.toServiceResultProto(res)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult resProto = ServiceResultProtoConverter.toServiceResultProto(res);
        Long userId = res.getData();
        responseObserver.onNext(UserServiceProto.UserIdResponse.newBuilder().setUserId(userId).setResult(resProto).build());
        responseObserver.onCompleted();
    }


    @Override
    public void getUserByName(UserServiceProto.UserNameRequest request, StreamObserver<UserServiceProto.UserInfoResponse> responseObserver) {
        ServiceResult<UserInfo> res = userService.getUserByName(request.getUserName());
        if (!res.isSuccess()) {
            UserServiceProto.UserInfoResponse response = UserServiceProto.UserInfoResponse.newBuilder().setResult(ServiceResultProtoConverter.toServiceResultProto(res)).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }
        ServiceResultProto.ServiceResult resProto = ServiceResultProtoConverter.toServiceResultProto(res);
        UserInfo userInfo = res.getData();
        UserServiceProto.UserInfo userInfoProto = UserProtoConverter.toUserInfoProto(userInfo);
        UserServiceProto.UserInfoResponse response = UserServiceProto.UserInfoResponse.newBuilder().setUserInfo(userInfoProto).setResult(resProto).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    @Override
    public void checkUserExists(UserServiceProto.UserIdRequest request, StreamObserver<UserServiceProto.CheckUserExistsResponse> responseObserver) {
        ServiceResult<Boolean> res = userService.checkUserExists(request.getUserId());
        ServiceResultProto.ServiceResult resProto = ServiceResultProtoConverter.toServiceResultProto(res);
        responseObserver.onNext(UserServiceProto.CheckUserExistsResponse.newBuilder().setResult(resProto).setExists(res.getData()).build());
        responseObserver.onCompleted();
    }
}
