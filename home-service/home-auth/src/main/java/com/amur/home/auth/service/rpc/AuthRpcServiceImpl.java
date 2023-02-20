package com.amur.home.auth.service.rpc;

import com.amur.home.auth.converter.AuthProtoConverter;
import com.amur.home.auth.entity.UserAuth;
import com.amur.home.auth.rpc.AuthServiceGrpc;
import com.amur.home.auth.rpc.AuthServiceProto;
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
            responseObserver.onError(new Exception(res.getMessage()));
            return;
        }
        responseObserver.onNext(AuthServiceProto.GetAuthByIdResponse.newBuilder().setAuth(AuthProtoConverter.toUserAuthProto(res.getData())).build());
        responseObserver.onCompleted();
    }
}
