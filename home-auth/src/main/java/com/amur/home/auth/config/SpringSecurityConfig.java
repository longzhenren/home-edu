//package com.amur.home.auth.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @author 海加尔金鹰 www.hjljy.cn
// * @apiNote websecurtiy权限校验处理
// * @since 2020/9/11
// **/
//@Configuration
//@EnableWebSecurity
//@EnableGlobalAuthentication
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    /**
//     * 描述:
//     * http方式走 Spring Security 过滤器链，在过滤器链中，给请求放行，而web方式是不走 Spring Security 过滤器链。
//     * 通常http方式用于请求的放行和限制，web方式用于放行静态资源
//     **/
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                //用于配置直接放行的请求
//                .antMatchers("/login","/token", "/actuator/**", "/swagger-ui.html", "/swagger-resources/**", "/v3/api-docs", "/webjars/**", "/doc.html").permitAll()
//                //其余请求都需要验证
//                .anyRequest().authenticated()
//                //授权码模式需要 会弹出默认自带的登录框
////                .and().httpBasic()
//                //禁用跨站伪造
//                .and().csrf().disable();
//        //如果项目没有前后端分离，还可以通过 formlogin配置登录相关的页面和请求处理
//        // 使用自定义的认证过滤器
//        // http.addFilterBefore(new  MyLoginFilter(authenticationManager()),UsernamePasswordAuthenticationFilter.class);
//    }
//
//    /**
//     * 描述: 静态资源放行，这里的放行，是不走 Spring Security 过滤器链
//     **/
//    @Override
//    public void configure(WebSecurity web) {
//        // 可以直接访问的静态数据
//        web.ignoring()
//                .antMatchers("/css/**")
//                .antMatchers("/404.html")
//                .antMatchers("/500.html")
//                .antMatchers("/html/**")
//                .antMatchers("/js/**");
//    }
//}