package com.amur.home.common;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public class Constants {

    @AllArgsConstructor
    @Getter
    public enum ResultCode {
        TOKEN_ERR(5, "token is error"),
        SYS_ERR(6, "sys error"),
        SUCCESS(0, "success");

        private Integer code;
        private String message;
    }

    @AllArgsConstructor
    @Getter
    public enum IdConstants {
        LOADING_PERCENT(20, "预加载下个号段的百分比"),
        RETRY(3, "重试次数");
        final int value;
        final String desc;
    }

    @AllArgsConstructor
    @Getter
    public enum SystemConstants {
        DEFAULT_NULL_MESSAGE(0, "承载数据空"),
        DEFAULT_SUCCESS_MESSAGE(1, "操作成功"),
        DEFAULT_FAILURE_MESSAGE(2, "操作失败"),
        DEFAULT_UNAUTHORIZED_MESSAGE(3, "认证失败");
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
        NONE("NONE", "无", 0),
        FATHER("FATHER", "父亲", 1),
        MOTHER("MOTHER", "母亲", 2),
        SON("SON", "儿子", 3),
        DAUGHTER("DAUGHTER", "女儿", 4),
        GRANDFATHER("GRANDFATHER", "祖父", 5),
        GRANDMOTHER("GRANDMOTHER", "祖母", 6),
        BROTHER("BROTHER", "哥哥", 7),
        SISTER("SISTER", "姐姐", 8),
        UNCLE("UNCLE", "叔叔", 9),
        AUNT("AUNT", "阿姨", 10),
        OTHER("OTHER", "其他", 11);
        private final String rpcType;
        private final String description;
        @EnumValue
        private final int value;

        public static UserRelativeType valueOf(int value) {
            for (UserRelativeType userRelativeType : UserRelativeType.values()) {
                if (userRelativeType.value == value) {
                    return userRelativeType;
                }
            }
            return null;
        }
    }

    public enum Home {

    }

    @AllArgsConstructor
    @Getter
    public enum CacheNames {
        CAPTCHA_KEY("auth:captcha:");
        @EnumValue
        private final String value;
    }

    @AllArgsConstructor
    @Getter
    public enum InviteAs {
        AS_TEACHER(1, "作为老师加入课程"),
        AS_STUDENT(2, "作为老师加入课程");
        @EnumValue
        private final int value;
        private final String desc;

        public static InviteAs valueOf(int value) {
            for (InviteAs inviteAs : InviteAs.values()) {
                if (inviteAs.value == value) {
                    return inviteAs;
                }
            }
            return null;
        }
    }

    @AllArgsConstructor
    @Getter
    public enum ServiceName {
        HOME_SERVICE("home-service"),
        HOME_USER("home-user"),
        HOME_COURSE("home-course"),
        HOME_RTC("home-rtc"),
        HOME_MSG("home-msg"),
        HOME_GATEWAY("home-gateway"),
        HOME_AUTH("home-auth"),
        HOME_COMMON("home-common"),
        HOME_SBA("home-sba"),
        HOME_TINYID("home-tinyid");
        private final String desc;
    }

    @AllArgsConstructor
    @Getter
    public enum TableName {
        USER_INFO("user_info"),
        USER_AUTH("user_auth"),
        USER_PERMISSION("user_permission"),
        USER_FAV("user_fav"),
        HOME_INFO("home_info"),
        COURSE_COMMENT("course_comment"),
        COURSE_INFO("course_info"),
        COURSE_SHARE("course_share"),
        COURSE_LIST("course_list"),
        COURSE_WARE("course_ware"),
        COURSE_JOIN("course_join"),
        USER("user"),
        SCHEDULE("schedule");
        private final String desc;
    }

    @AllArgsConstructor
    @Getter
    public enum PermissionName {
        USER("user"),
        SU("su"),
        HOME_ADMIN("home_admin"),
        SYS_ADMIN("sys_admin"),
        SRE("sre");
        private final String name;
    }

    @AllArgsConstructor
    @Getter
    public enum RoleName {
        USER("user"),
        HOME_ADMIN("home_admin");
        private final String name;
    }
}
