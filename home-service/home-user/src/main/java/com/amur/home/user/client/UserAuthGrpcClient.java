package com.amur.home.user.client;

import com.amur.home.auth.converter.AuthProtoConverter;
import com.amur.home.auth.entity.UserAuth;
import com.amur.home.auth.rpc.AuthServiceGrpc;
import com.amur.home.auth.rpc.AuthServiceProto;
import com.amur.home.auth.rpc.ServiceResultProto;
import com.amur.home.util.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserAuthGrpcClient {
    @GrpcClient("home-auth")
    private AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub;

    public UserAuth getUserAuthById(Long userId) {
        AuthServiceProto.GetAuthByIdRequest req = AuthServiceProto.GetAuthByIdRequest.newBuilder().setId(userId).build();
        AuthServiceProto.GetAuthByIdResponse resp = authServiceBlockingStub.getAuthById(req);
        AuthServiceProto.UserAuth userAuthProto = resp.getAuth();
        return AuthProtoConverter.toUserAuth(userAuthProto);
    }

    public ServiceResult<Void> addPermission(Long userId, String permission) {
        AuthServiceProto.AddPermissionRequest req = AuthServiceProto.AddPermissionRequest.newBuilder().setId(userId).setPermission(permission).build();
        ServiceResultProto.ServiceResult resp = authServiceBlockingStub.addPermission(req);
        if (resp.getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail(resp.getMessage());
        }
    }

    public ServiceResult<Void> removePermission(Long userId, String permission) {
        AuthServiceProto.RemovePermissionRequest req = AuthServiceProto.RemovePermissionRequest.newBuilder().setId(userId).setPermission(permission).build();
        ServiceResultProto.ServiceResult resp = authServiceBlockingStub.removePermission(req);
        if (resp.getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail(resp.getMessage());
        }
    }

    public ServiceResult<Void> addRole(Long userId, String role) {
        AuthServiceProto.AddRoleRequest req = AuthServiceProto.AddRoleRequest.newBuilder().setId(userId).setRole(role).build();
        ServiceResultProto.ServiceResult resp = authServiceBlockingStub.addRole(req);
        if (resp.getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail(resp.getMessage());
        }
    }

    public ServiceResult<Void> removeRole(Long userId, String role) {
        AuthServiceProto.RemoveRoleRequest req = AuthServiceProto.RemoveRoleRequest.newBuilder().setId(userId).setRole(role).build();
        ServiceResultProto.ServiceResult resp = authServiceBlockingStub.removeRole(req);
        if (resp.getSuccess()) {
            return ServiceResult.success();
        } else {
            return ServiceResult.fail(resp.getMessage());
        }
    }

}
