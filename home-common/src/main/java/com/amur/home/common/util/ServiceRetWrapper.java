package com.amur.home.common.util;

import com.amur.home.common.constant.Constants.StatusCode;
import com.amur.home.common.constant.Constants.SystemConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Optional;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class ServiceRetWrapper<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private boolean isSuccess;
    private T data;
    private String msg;

    private ServiceRetWrapper(StatusCode statusCode) {
        this(statusCode, null, statusCode.getMessage());
    }

    private ServiceRetWrapper(StatusCode statusCode, String msg) {
        this(statusCode, null, msg);
    }

    private ServiceRetWrapper(StatusCode statusCode, T data) {
        this(statusCode, data, statusCode.getMessage());
    }

    private ServiceRetWrapper(StatusCode statusCode, T data, String msg) {

    }

    private ServiceRetWrapper(int code, T data, String msg) {
        this.code = String.valueOf(code);
        this.data = data;
        this.msg = msg;
        this.isSuccess = StatusCode.SUCCESS.getCode().equals(String.valueOf(code));
    }

    public ServiceRetWrapper(String code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.isSuccess = StatusCode.SUCCESS.getCode().equals(code);
    }

    public static boolean isSuccess(@Nullable ServiceRetWrapper<?> result) {
        return Optional.ofNullable(result)
                .map(x -> ObjectUtil.nullSafeEquals(StatusCode.SUCCESS.getCode(), x.code))
                .orElse(Boolean.FALSE);
    }

    public static boolean isNotSuccess(@Nullable ServiceRetWrapper<?> result) {
        return !ServiceRetWrapper.isSuccess(result);
    }

    public static <T> ServiceRetWrapper<T> data(T data) {
        return data(data, SystemConstants.DEFAULT_SUCCESS_MESSAGE.getMessage());
    }

    public static <T> ServiceRetWrapper<T> data(T data, String msg) {
        return data(StatusCode.SUCCESS.getCode(), data, msg);
    }

    public static <T> ServiceRetWrapper<T> data(int code, T data, String msg) {
        return new ServiceRetWrapper<>(code, data, data == null ? SystemConstants.DEFAULT_NULL_MESSAGE.getMessage() : msg);
    }

    public static <T> ServiceRetWrapper<T> data(String code, T data, String msg) {
        return new ServiceRetWrapper<>(code, data, data == null ? SystemConstants.DEFAULT_NULL_MESSAGE.getMessage() : msg);
    }

    public static <T> ServiceRetWrapper<T> success(String msg) {
        return new ServiceRetWrapper<>(StatusCode.SUCCESS, msg);
    }

    public static <T> ServiceRetWrapper<T> success(StatusCode statusCode) {
        return new ServiceRetWrapper<>(statusCode);
    }

    public static <T> ServiceRetWrapper<T> success(StatusCode statusCode, String msg) {
        return new ServiceRetWrapper<>(statusCode, msg);
    }

    public static <T> ServiceRetWrapper<T> fail(String msg) {
        return new ServiceRetWrapper<>(StatusCode.FAILURE, msg);
    }

    public static <T> ServiceRetWrapper<T> fail(int code, String msg) {
        return new ServiceRetWrapper<>(code, null, msg);
    }

    public static <T> ServiceRetWrapper<T> fail(StatusCode statusCode) {
        return new ServiceRetWrapper<>(statusCode);
    }

    public static <T> ServiceRetWrapper<T> fail(StatusCode statusCode, String msg) {
        return new ServiceRetWrapper<>(statusCode, msg);
    }

    public static <T> ServiceRetWrapper<T> status(boolean flag) {
        return flag ? success(SystemConstants.DEFAULT_SUCCESS_MESSAGE.getMessage()) : fail(SystemConstants.DEFAULT_FAILURE_MESSAGE.getMessage());
    }

}
