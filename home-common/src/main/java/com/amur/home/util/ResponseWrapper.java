package com.amur.home.util;

import com.amur.home.common.Constants.StatusCode;
import com.amur.home.common.Constants.SystemConstants;
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
public class ResponseWrapper<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private boolean isSuccess;
    private T data;
    private String msg;

    private ResponseWrapper(StatusCode statusCode) {
        this(statusCode, null, statusCode.getMessage());
    }

    private ResponseWrapper(StatusCode statusCode, String msg) {
        this(statusCode, null, msg);
    }

    private ResponseWrapper(StatusCode statusCode, T data) {
        this(statusCode, data, statusCode.getMessage());
    }

    private ResponseWrapper(StatusCode statusCode, T data, String msg) {
        this(statusCode.getCode(), data, msg);
    }

    private ResponseWrapper(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.isSuccess = StatusCode.SUCCESS.getCode() == code;
    }

    public static boolean isSuccess(@Nullable ResponseWrapper<?> result) {
        return Optional.ofNullable(result)
                .map(x -> ObjectUtil.nullSafeEquals(StatusCode.SUCCESS.getCode(), x.code))
                .orElse(Boolean.FALSE);
    }

    public static boolean isNotSuccess(@Nullable ResponseWrapper<?> result) {
        return !ResponseWrapper.isSuccess(result);
    }

    public static <T> ResponseWrapper<T> data(T data) {
        return data(data, SystemConstants.DEFAULT_SUCCESS_MESSAGE.getMessage());
    }

    public static <T> ResponseWrapper<T> data(T data, String msg) {
        return data(StatusCode.SUCCESS.getCode(), data, msg);
    }

    public static <T> ResponseWrapper<T> data(int code, T data, String msg) {
        return new ResponseWrapper<>(code, data, data == null ? SystemConstants.DEFAULT_NULL_MESSAGE.getMessage() : msg);
    }

    public static <T> ResponseWrapper<T> success(String msg) {
        return new ResponseWrapper<>(StatusCode.SUCCESS, msg);
    }

    public static <T> ResponseWrapper<T> success(StatusCode statusCode) {
        return new ResponseWrapper<>(statusCode);
    }

    public static <T> ResponseWrapper<T> success(StatusCode statusCode, String msg) {
        return new ResponseWrapper<>(statusCode, msg);
    }

    public static <T> ResponseWrapper<T> fail(String msg) {
        return new ResponseWrapper<>(StatusCode.FAILURE, msg);
    }

    public static <T> ResponseWrapper<T> fail(int code, String msg) {
        return new ResponseWrapper<>(code, null, msg);
    }

    public static <T> ResponseWrapper<T> fail(StatusCode statusCode) {
        return new ResponseWrapper<>(statusCode);
    }

    public static <T> ResponseWrapper<T> fail(StatusCode statusCode, String msg) {
        return new ResponseWrapper<>(statusCode, msg);
    }

    public static <T> ResponseWrapper<T> status(boolean flag) {
        return flag ? success(SystemConstants.DEFAULT_SUCCESS_MESSAGE.getMessage()) : fail(SystemConstants.DEFAULT_FAILURE_MESSAGE.getMessage());
    }

}
