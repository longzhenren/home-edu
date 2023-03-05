package com.amur.home.auth.service.rpc;

import com.amur.home.auth.converter.AuthProtoConverter;
import com.amur.home.auth.entity.UserAuth;
import com.amur.home.auth.rpc.AuthServiceGrpc;
import com.amur.home.auth.rpc.AuthServiceProto;
import com.amur.home.auth.rpc.ServiceResultProto;
import com.amur.home.auth.service.AuthService;
import com.amur.home.util.ServiceResult;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import javax.annotation.Resource;

@GrpcService
public class AuthRpcServiceImpl extends AuthServiceGrpc.AuthServiceImplBase {
    @Resource
    private AuthService authService;

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getAuthById(AuthServiceProto.GetAuthByIdRequest request, StreamObserver<AuthServiceProto.GetAuthByIdResponse> responseObserver) {
        ServiceResult<UserAuth> res = authService.getUserAuthById(request.getId());
        if (!res.isSuccess()) {
            responseObserver.onNext(AuthServiceProto.GetAuthByIdResponse.newBuilder().setResult(ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage(res.getMessage()).build()).build());
            responseObserver.onCompleted();
            return;
        }
        responseObserver.onNext(AuthServiceProto.GetAuthByIdResponse.newBuilder().setAuth(AuthProtoConverter.toUserAuthProto(res.getData())).build());
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void addPermission(AuthServiceProto.AddPermissionRequest request, StreamObserver<ServiceResultProto.ServiceResult> responseObserver) {
        ServiceResult<Void> res = authService.addPermission(request.getId(), request.getPermission());
        if (!res.isSuccess()) {
            responseObserver.onNext(ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage(res.getMessage()).build());
            responseObserver.onCompleted();
        }
        responseObserver.onNext(ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void removePermission(AuthServiceProto.RemovePermissionRequest request, StreamObserver<ServiceResultProto.ServiceResult> responseObserver) {
        ServiceResult<Void> res = authService.removePermission(request.getId(), request.getPermission());
        if (!res.isSuccess()) {
            responseObserver.onNext(ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage(res.getMessage()).build());
            responseObserver.onCompleted();
        }
        responseObserver.onNext(ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void addRole(AuthServiceProto.AddRoleRequest request, StreamObserver<ServiceResultProto.ServiceResult> responseObserver) {
        ServiceResult<Void> res = authService.addRole(request.getId(), request.getRole());
        if (!res.isSuccess()) {
            responseObserver.onNext(ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage(res.getMessage()).build());
            responseObserver.onCompleted();
        }
        responseObserver.onNext(ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();
    }

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void removeRole(AuthServiceProto.RemoveRoleRequest request, StreamObserver<ServiceResultProto.ServiceResult> responseObserver) {
        ServiceResult<Void> res = authService.removeRole(request.getId(), request.getRole());
        if (!res.isSuccess()) {
            responseObserver.onNext(ServiceResultProto.ServiceResult.newBuilder().setSuccess(false).setMessage(res.getMessage()).build());
            responseObserver.onCompleted();
        }
        responseObserver.onNext(ServiceResultProto.ServiceResult.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();
        super.removeRole(request, responseObserver);
    }
}
