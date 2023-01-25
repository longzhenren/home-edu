package com.amur.home.gateway.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
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
                // 开放地址
                .addExclude("/doc.html", "/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/v3/**", "/actuator/**", "/favicon.ico").addExclude("/home-sba/**").addExclude("/home-user/v3/**", "/home-user/swagger-resources/**", "/home-user/webjars/**", "/home-user/swagger-ui.html/**", "/home-user/doc.html", "/home-user/actuator/**").addExclude("/home-course/v3/**", "/home-course/swagger-resources/**", "/home-course/webjars/**", "/home-course/swagger-ui.html/**", "/home-course/doc.html", "/home-course/actuator/**").addExclude("/home-tinyid/v3/**", "/home-tinyid/swagger-resources/**", "/home-tinyid/webjars/**", "/home-tinyid/swagger-ui.html/**", "/home-tinyid/doc.html", "/home-tinyid/actuator/**")
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 登录校验 -- 拦截所有路由，并放行登录
                    SaRouter.match("/**", "/home-auth/login", r -> StpUtil.checkLogin());
                    // 权限认证 -- 不同模块, 校验不同权限
                    SaRouter.match("/home-user/**", r -> StpUtil.checkPermission("user"));
                    SaRouter.match("/home-sba/**", r -> StpUtil.checkPermissionOr("su", "sre"));
                    SaRouter.match("/home-sw/**", r -> StpUtil.checkPermissionOr("su", "sre"));
                });
        // 异常处理方法：每次setAuth函数出现异常时进入
//                .setError(e -> SaResult.error(e.getMessage()));
    }
}
