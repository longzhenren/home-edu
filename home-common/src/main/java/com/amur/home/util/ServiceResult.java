package com.amur.home.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success;
    private String message;
    private T data;

    public ServiceResult(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.data = null;
    }

    public ServiceResult(boolean success) {
        this.success = success;
        this.message = null;
        this.data = null;
    }

    public ServiceResult(boolean success, T data) {
        this.success = success;
        this.message = null;
        this.data = data;
    }

    public static <T> ServiceResult<T> fail(String message) {
        return new ServiceResult<>(false, message);
    }

//    public static <T> ServiceResult<T> success(String message) {
//        return new ServiceResult<>(true, message);
//    }

    public static <T> ServiceResult<T> success() {
        return new ServiceResult<>(true);
    }

    public static boolean isSuccess(ServiceResult<?> r) {
        return r.success;
    }

    public static <T> ServiceResult<T> success(boolean success, String message, T data) {
        return new ServiceResult<>(success, message, data);
    }

    public static <T> ServiceResult<T> success(String message, T data) {
        return new ServiceResult<>(true, message, data);
    }

    public static <T> ServiceResult<T> success(T data) {
        return new ServiceResult<>(true, data);
    }

    public boolean isSuccess() {
        return this.success;
    }

}
