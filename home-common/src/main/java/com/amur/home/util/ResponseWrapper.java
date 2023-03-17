package com.amur.home.util;

import com.amur.home.common.Constants.StatusCode;
import com.amur.home.common.Constants.SystemConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

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
    private String message;

    private ResponseWrapper(StatusCode statusCode) {
        this(statusCode, null, statusCode.getMessage());
    }

    private ResponseWrapper(StatusCode statusCode, String message) {
        this(statusCode, null, message);
    }

    private ResponseWrapper(StatusCode statusCode, T data) {
        this(statusCode, data, statusCode.getMessage());
    }

    private ResponseWrapper(StatusCode statusCode, T data, String message) {
        this(statusCode.getCode(), data, message);
    }

    private ResponseWrapper(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.isSuccess = StatusCode.SUCCESS.getCode() == code;
    }

    public static boolean isSuccess(@Nullable ResponseWrapper<?> result) {
        return Optional.ofNullable(result).map(x -> ObjectUtils.nullSafeEquals(StatusCode.SUCCESS.getCode(), x.code)).orElse(Boolean.FALSE);
    }

    public static boolean isNotSuccess(@Nullable ResponseWrapper<?> result) {
        return !ResponseWrapper.isSuccess(result);
    }

    public static <T> ResponseWrapper<T> data(T data) {
        return data(data, SystemConstants.DEFAULT_SUCCESS_MESSAGE.getMessage());
    }

    public static <T> ResponseWrapper<T> data(T data, String message) {
        return data(StatusCode.SUCCESS.getCode(), data, message);
    }

    public static <T> ResponseWrapper<T> data(int code, T data, String message) {
        return new ResponseWrapper<>(code, data, data == null ? SystemConstants.DEFAULT_NULL_MESSAGE.getMessage() : message);
    }

    public static <T> ResponseWrapper<T> success(String message) {
        return new ResponseWrapper<>(StatusCode.SUCCESS, message);
    }

    public static <T> ResponseWrapper<T> success(StatusCode statusCode) {
        return new ResponseWrapper<>(statusCode);
    }

    public static <T> ResponseWrapper<T> success(StatusCode statusCode, String message) {
        return new ResponseWrapper<>(statusCode, message);
    }

    public static <T> ResponseWrapper<T> fail(String message) {
        return new ResponseWrapper<>(StatusCode.FAILURE, message);
    }

    public static <T> ResponseWrapper<T> fail(int code, String message) {
        return new ResponseWrapper<>(code, null, message);
    }

    public static <T> ResponseWrapper<T> fail(StatusCode statusCode) {
        return new ResponseWrapper<>(statusCode);
    }

    public static <T> ResponseWrapper<T> fail(StatusCode statusCode, String message) {
        return new ResponseWrapper<>(statusCode, message);
    }

    public static <T> ResponseWrapper<T> status(boolean flag) {
        return flag ? success(SystemConstants.DEFAULT_SUCCESS_MESSAGE.getMessage()) : fail(SystemConstants.DEFAULT_FAILURE_MESSAGE.getMessage());
    }

}
