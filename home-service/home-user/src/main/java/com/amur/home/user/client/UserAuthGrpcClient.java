package com.amur.home.user.client;

import com.amur.home.auth.converter.AuthProtoConverter;
import com.amur.home.auth.entity.UserAuth;
import com.amur.home.auth.rpc.AuthServiceGrpc;
import com.amur.home.auth.rpc.AuthServiceProto;
import net.devh.boot.grpc.client.inject.GrpcClient;

public class UserAuthGrpcClient {
    @GrpcClient("home-auth")
    private AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub;

    public UserAuth getUserAuthById(Long userId) {
        AuthServiceProto.GetAuthByIdRequest req = AuthServiceProto.GetAuthByIdRequest.newBuilder().setId(userId).build();
        AuthServiceProto.GetAuthByIdResponse resp = authServiceBlockingStub.getAuthById(req);
        AuthServiceProto.UserAuth userAuthProto = resp.getAuth();
        return AuthProtoConverter.toUserAuth(userAuthProto);
    }
}
