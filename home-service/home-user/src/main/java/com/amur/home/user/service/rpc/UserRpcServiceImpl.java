package com.amur.home.user.service.rpc;

import com.amur.home.user.converter.UserProtoConverter;
import com.amur.home.user.entity.UserInfo;
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

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getUserInfo(UserServiceProto.UserIdRequest request, StreamObserver<UserServiceProto.UserInfoResponse> responseObserver) {
        ServiceResult<UserInfo> res = userService.getUserInfo(request.getUserId());
        if (!res.isSuccess()) {
            responseObserver.onError(new Exception(res.getMessage()));
            return;
        }
        UserServiceProto.UserInfo userInfoProto = UserProtoConverter.toUserInfoProto(res.getData());
        UserServiceProto.UserInfoResponse response = UserServiceProto.UserInfoResponse.newBuilder().setUserInfo(userInfoProto).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void updateUser(UserServiceProto.UserInfoRequest request, StreamObserver<UserServiceProto.ServiceResult> responseObserver) {
        UserServiceProto.UserInfo userInfoProto = request.getUserInfo();
        UserInfo userInfo = UserProtoConverter.toUserInfo(userInfoProto);
        ServiceResult<Void> res = userService.updateUser(userInfo);
        responseObserver.onNext(UserServiceProto.ServiceResult.newBuilder().setSuccess(res.isSuccess()).setMessage(res.getMessage()).build());
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void deleteUser(UserServiceProto.UserIdRequest request, StreamObserver<UserServiceProto.ServiceResult> responseObserver) {
        ServiceResult<Void> res = userService.deleteUser(request.getUserId());
        responseObserver.onNext(UserServiceProto.ServiceResult.newBuilder().setSuccess(res.isSuccess()).setMessage(res.getMessage()).build());
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void createUser(UserServiceProto.UserInfoRequest request, StreamObserver<UserServiceProto.UserIdResponse> responseObserver) {
        UserServiceProto.UserInfo userInfoProto = request.getUserInfo();
        UserInfo userInfo = UserProtoConverter.toUserInfo(userInfoProto);
        ServiceResult<Long> res = userService.createUser(userInfo);
        if (!res.isSuccess()) {
            responseObserver.onError(new Exception(res.getMessage()));
            return;
        }
        Long userId = res.getData();
        responseObserver.onNext(UserServiceProto.UserIdResponse.newBuilder().setUserId(userId).build());
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getUserByName(UserServiceProto.UserNameRequest request, StreamObserver<UserServiceProto.UserInfoResponse> responseObserver) {
        ServiceResult<UserInfo> res = userService.getUserByName(request.getUserName());
        if (!res.isSuccess()) {
            responseObserver.onError(new Exception(res.getMessage()));
            return;
        }
        UserInfo userInfo = res.getData();
        UserServiceProto.UserInfo userInfoProto = UserProtoConverter.toUserInfoProto(userInfo);
        UserServiceProto.UserInfoResponse response = UserServiceProto.UserInfoResponse.newBuilder().setUserInfo(userInfoProto).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
