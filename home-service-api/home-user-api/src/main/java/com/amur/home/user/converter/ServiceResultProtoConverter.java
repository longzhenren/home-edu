package com.amur.home.user.converter;

import com.amur.home.user.rpc.ServiceResultProto;
import com.amur.home.util.ServiceResult;

public class ServiceResultProtoConverter {

    public static <T> ServiceResultProto.ServiceResult toServiceResultProto(ServiceResult<T> serviceResult) {
        return ServiceResultProto.ServiceResult.newBuilder().setSuccess(serviceResult.isSuccess()).setMessage(serviceResult.getMessage() == null ? "" : serviceResult.getMessage()).build();
    }

    public static <T> ServiceResult<T> toServiceResult(ServiceResultProto.ServiceResult serviceResultProto) {
        return new ServiceResult<>(serviceResultProto.getSuccess(), serviceResultProto.getMessage());
    }
}
