package com.amur.home.common.api;

import com.amur.home.common.Constants.ResponseCode;
import com.amur.home.common.Constants.SystemConstants;
import com.amur.home.util.ObjectUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletResponse;
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

    private ResponseWrapper(ResponseCode responseCode) {
        this(responseCode, null, responseCode.getMessage());
    }

    private ResponseWrapper(ResponseCode responseCode, String msg) {
        this(responseCode, null, msg);
    }

    private ResponseWrapper(ResponseCode responseCode, T data) {
        this(responseCode, data, responseCode.getMessage());
    }

    private ResponseWrapper(ResponseCode responseCode, T data, String msg) {
        this(responseCode.getCode(), data, msg);
    }

    private ResponseWrapper(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.isSuccess = ResponseCode.SUCCESS.getCode() == code;
    }

    public static boolean isSuccess(@Nullable ResponseWrapper<?> result) {
        return Optional.ofNullable(result)
                .map(x -> ObjectUtil.nullSafeEquals(ResponseCode.SUCCESS.getCode(), x.code))
                .orElse(Boolean.FALSE);
    }

    public static boolean isNotSuccess(@Nullable ResponseWrapper<?> result) {
        return !ResponseWrapper.isSuccess(result);
    }

    public static <T> ResponseWrapper<T> data(T data) {
        return data(data, SystemConstants.DEFAULT_SUCCESS_MESSAGE.getMessage());
    }

    public static <T> ResponseWrapper<T> data(T data, String msg) {
        return data(HttpServletResponse.SC_OK, data, msg);
    }

    public static <T> ResponseWrapper<T> data(int code, T data, String msg) {
        return new ResponseWrapper<>(code, data, data == null ? SystemConstants.DEFAULT_NULL_MESSAGE.getMessage() : msg);
    }

    public static <T> ResponseWrapper<T> success(String msg) {
        return new ResponseWrapper<>(ResponseCode.SUCCESS, msg);
    }

    public static <T> ResponseWrapper<T> success(ResponseCode responseCode) {
        return new ResponseWrapper<>(responseCode);
    }

    public static <T> ResponseWrapper<T> success(ResponseCode responseCode, String msg) {
        return new ResponseWrapper<>(responseCode, msg);
    }

    public static <T> ResponseWrapper<T> fail(String msg) {
        return new ResponseWrapper<>(ResponseCode.FAILURE, msg);
    }

    public static <T> ResponseWrapper<T> fail(int code, String msg) {
        return new ResponseWrapper<>(code, null, msg);
    }

    public static <T> ResponseWrapper<T> fail(ResponseCode responseCode) {
        return new ResponseWrapper<>(responseCode);
    }

    public static <T> ResponseWrapper<T> fail(ResponseCode responseCode, String msg) {
        return new ResponseWrapper<>(responseCode, msg);
    }

    public static <T> ResponseWrapper<T> status(boolean flag) {
        return flag ? success(SystemConstants.DEFAULT_SUCCESS_MESSAGE.getMessage()) : fail(SystemConstants.DEFAULT_FAILURE_MESSAGE.getMessage());
    }

}
