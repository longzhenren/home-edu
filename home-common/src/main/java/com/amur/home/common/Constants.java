package com.amur.home.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public class Constants {
    @AllArgsConstructor
    @Getter
    public enum SystemConstants {
        DEFAULT_NULL_MESSAGE(0,"承载数据空"),
        DEFAULT_SUCCESS_MESSAGE(1,"操作成功"),
        DEFAULT_FAILURE_MESSAGE(2,"操作失败"),
        DEFAULT_UNAUTHORIZED_MESSAGE(3,"认证失败");
        final int code;
        final String message;
    }

    @AllArgsConstructor
    @Getter
    public enum StatusCode implements Serializable {
        SUCCESS(HttpServletResponse.SC_OK, "操作成功"),
        FAILURE(HttpServletResponse.SC_BAD_REQUEST, "业务异常"),
        UN_AUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "请求未授权"),
        NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, "没找到请求"),
        MSG_NOT_READABLE(HttpServletResponse.SC_BAD_REQUEST, "消息不能读取"),
        METHOD_NOT_SUPPORTED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "不支持当前请求方法"),
        MEDIA_TYPE_NOT_SUPPORTED(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "不支持当前媒体类型"),
        REQ_REJECT(HttpServletResponse.SC_FORBIDDEN, "请求被拒绝"),
        INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "服务器异常"),
        PARAM_MISS(HttpServletResponse.SC_BAD_REQUEST, "缺少必要的请求参数"),
        PARAM_TYPE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "请求参数类型错误"),
        PARAM_BIND_ERROR(HttpServletResponse.SC_BAD_REQUEST, "请求参数绑定错误"),
        PARAM_VALID_ERROR(HttpServletResponse.SC_BAD_REQUEST, "参数校验失败");
        final int code;
        final String message;
    }

    @AllArgsConstructor
    @Getter
    public enum UserRelativeType {
        FATHER("FATHER", "父亲",0),
        MOTHER("MOTHER", "母亲",1),
        SON("SON", "儿子",2),
        DAUGHTER("DAUGHTER", "女儿",3),
        GRANDFATHER("GRANDFATHER", "祖父",4),
        GRANDMOTHER("GRANDMOTHER", "祖母",5),
        BROTHER("BROTHER", "哥哥",6),
        SISTER("SISTER", "姐姐",7),
        UNCLE("UNCLE", "叔叔",8),
        AUNT("AUNT", "阿姨",9),
        OTHER("OTHER", "其他",10);
        private final String description;
        private final String name;
        private final int value;
    }

    public enum Home {

    }
}
