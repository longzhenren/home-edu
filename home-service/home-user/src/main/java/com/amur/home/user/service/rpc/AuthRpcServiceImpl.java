package com.amur.home.user.service.rpc;

import com.amur.home.user.entity.AuthEntity;
import com.amur.home.user.entity.UserEntity;
import com.amur.home.user.rpc.Auth;
import com.amur.home.user.rpc.AuthServiceGrpc;
import com.amur.home.user.rpc.StatusOuterClass;
import com.amur.home.user.rpc.User;
import com.amur.home.user.service.impl.AuthServiceImpl;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import com.amur.home.core.tool.utils.Func;

import javax.annotation.Resource;

@Slf4j
@GrpcService
public class AuthRpcServiceImpl extends AuthServiceGrpc.AuthServiceImplBase {
    @Resource
    private AuthServiceImpl authService;

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getAuthEntity(Auth.GetAuthEntityReq request, StreamObserver<Auth.GetAuthEntityResp> responseObserver) {
        AuthEntity authEntity = authService.getAuthInfo(request.getUsername(), request.getPassword());
        Auth.GetAuthEntityResp response = buildResponse(authEntity);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAuthEntityByUserId(Auth.GetAuthEntityByUserIdReq request, StreamObserver<Auth.GetAuthEntityResp> responseObserver) {
        AuthEntity authEntity = authService.getAuthInfo(request.getUserId());
        Auth.GetAuthEntityResp response = buildResponse(authEntity);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private Auth.GetAuthEntityResp buildResponse(AuthEntity authEntity) {
        Auth.GetAuthEntityResp response = Auth.GetAuthEntityResp.newBuilder().build();
        if (authEntity == null) {
            response.toBuilder().setStatus(StatusOuterClass.Status.FAILED).build();
        } else {
            UserEntity user = authEntity.getUser();
            Auth.UserAuth auth = Auth.UserAuth.newBuilder()
                    .setRelativeType(User.UserRelativeType.valueOf(user.getRelativeType().getRpcType()))
                    .setAvatarUrl(Func.toStr(user.getAvatarUrl()))
                    .setName(Func.toStr(user.getName()))
                    .setPassword(Func.toStr(user.getPassword()))
                    .setPhone(Func.toStr(user.getPhone()))
                    .setId(Func.toLong(user.getId()))
                    .setDescription(Func.toStr(user.getDescription()))
                    .setEmail(Func.toStr(user.getEmail()))
                    .setCreatedAt(Func.formatDateTime(user.getCreateTime()))
                    .setHomeId(Func.toLong(user.getHomeId()))
                    .build();
            response = response.toBuilder().setUser(auth).addAllRoles(authEntity.getRoles()).setStatus(StatusOuterClass.Status.SUCCESS).build();
        }
        return response;
    }
}
