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
            response.toBuilder().setUser(Auth.UserAuth.newBuilder()
                    .setRelativeType(User.UserRelativeType.valueOf(user.getRelativeType().getName()))
                    .setAvatarUrl(user.getAvatarUrl())
                    .setName(user.getName())
                    .setPassword(user.getPassword())
                    .setPhone(user.getPhone())
                    .setId(user.getId())
                    .setDescription(user.getDescription())
                    .setEmail(user.getEmail())
                    .setCreatedAt(user.getCreateTime().toString())
                    .setHomeId(user.getHomeId())
                    .build()
            ).addAllRoles(authEntity.getRoles()).setStatus(StatusOuterClass.Status.SUCCESS).build();
        }
        return response;
    }
}
