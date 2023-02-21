package com.amur.home.user.converter;

import com.amur.home.user.rpc.UserServiceProto;
import com.amur.home.util.ServiceResult;

public class ServiceResultProtoConverter {

    public static <T> UserServiceProto.ServiceResult toServiceResultProto(ServiceResult<T> serviceResult) {
        return UserServiceProto.ServiceResult.newBuilder()
                .setSuccess(serviceResult.isSuccess())
                .setMessage(serviceResult.getMessage() == null ? "" : serviceResult.getMessage())
                .build();
    }

    public static <T> ServiceResult<T> toServiceResult(UserServiceProto.ServiceResult serviceResultProto) {
        return new ServiceResult<>(serviceResultProto.getSuccess(), serviceResultProto.getMessage());
    }
}
