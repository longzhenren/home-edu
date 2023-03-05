package com.amur.home.gateway.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.amur.home.util.ResponseWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * [Sa-Token 权限认证] 配置类
 *
 * @author kong
 */
@Configuration
public class SaTokenConfigure {
    // 注册 Sa-Token全局过滤器
    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")    /* 拦截全部path */
//                .addExclude("/**")
                .addExclude("/home-sba/**")    /* 放行sba监控 */
                .addExclude("/home-auth/login", "/home-auth/register", "/home-auth/captcha.jpg")    /* 放行登录注册 */
                // 开放地址
                .addExclude("/doc.html", "/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/v3/**", "/actuator/**", "/favicon.ico")
                .addExclude("/home-auth/v3/**", "/home-auth/swagger-resources/**", "/home-auth/webjars/**", "/home-auth/swagger-ui.html/**", "/home-auth/doc.html", "/home-auth/actuator/**")
                .addExclude("/home-schedule/v3/**", "/home-schedule/swagger-resources/**", "/home-schedule/webjars/**", "/home-schedule/swagger-ui.html/**", "/home-schedule/doc.html", "/home-schedule/actuator/**")
                .addExclude("/home-user/v3/**", "/home-user/swagger-resources/**", "/home-user/webjars/**", "/home-user/swagger-ui.html/**", "/home-user/doc.html", "/home-user/actuator/**")
                .addExclude("/home-course/v3/**", "/home-course/swagger-resources/**", "/home-course/webjars/**", "/home-course/swagger-ui.html/**", "/home-course/doc.html", "/home-course/actuator/**")
                .addExclude("/home-tinyid/v3/**", "/home-tinyid/swagger-resources/**", "/home-tinyid/webjars/**", "/home-tinyid/swagger-ui.html/**", "/home-tinyid/doc.html", "/home-tinyid/actuator/**")
                .addExclude("/home-rtc/v3/**", "/home-rtc/swagger-resources/**", "/home-rtc/webjars/**", "/home-rtc/swagger-ui.html/**", "/home-rtc/doc.html", "/home-rtc/actuator/**")
                .addExclude("/home-msg/v3/**", "/home-msg/swagger-resources/**", "/home-msg/webjars/**", "/home-msg/swagger-ui.html/**", "/home-msg/doc.html", "/home-msg/actuator/**")
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 登录校验 -- 拦截所有路由，并放行登录
                    SaRouter.match("/**", "/home-auth/login", r -> StpUtil.checkLogin());
                    // 权限认证 -- 不同模块, 校验不同权限
                    SaRouter.match("/home-user/**", "/home-schedule/**", "/home-course/**", "/home-rtc/**", "/home-msg/**").check(r -> StpUtil.checkPermission("user"));
                    SaRouter.match("/home-msg/announce/home/add", "/home-user/home/admin/**", "/home-user/home/del", "/home-user/home/user/add", "/home-user/home/user/del", "/home-course/share/token", "/home-course/course/del", "/home-course/course/add", "/home-course/stu/add", "/home-course/stu/del", "/home-course/teacher/add", "/home-course/teacher/del").check(r -> StpUtil.checkPermission("home_admin"));
                    SaRouter.match("/home-user/user/del").check(r -> StpUtil.checkPermission("sys_admin"));
                    SaRouter.match("/home-sba/**", r -> StpUtil.checkPermissionOr("su", "sre"));
                    SaRouter.match("/home-sw/**", r -> StpUtil.checkPermissionOr("su", "sre"));
                })
//         异常处理方法：每次setAuth函数出现异常时进入
                .setError(e -> ResponseWrapper.fail(e.getMessage()));
    }
}
