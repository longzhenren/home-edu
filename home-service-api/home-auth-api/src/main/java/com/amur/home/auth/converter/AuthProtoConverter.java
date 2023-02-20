package com.amur.home.auth.converter;

import com.amur.home.auth.entity.UserAuth;
import com.amur.home.auth.rpc.AuthServiceProto;

import java.util.HashSet;

public class AuthProtoConverter {
    public static AuthServiceProto.UserAuth toUserAuthProto(UserAuth userAuth) {
        AuthServiceProto.UserAuth.Builder builder = AuthServiceProto.UserAuth.newBuilder()
                .setId(userAuth.getId())
                .setPassword(userAuth.getPassword())
                .addAllRoles(userAuth.getRoles())
                .addAllPermissions(userAuth.getPermissions());

        return builder.build();
    }

    public static UserAuth toUserAuth(AuthServiceProto.UserAuth proto) {
        UserAuth userAuth = new UserAuth();
        userAuth.setId(proto.getId());
        userAuth.setPassword(proto.getPassword());
        userAuth.setRoles(new HashSet<>(proto.getRolesList()));
        userAuth.setPermissions(new HashSet<>(proto.getPermissionsList()));
        return userAuth;
    }
}
