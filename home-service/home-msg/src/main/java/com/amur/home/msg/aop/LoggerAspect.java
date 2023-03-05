package com.amur.home.msg.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Slf4j
@Component
public class LoggerAspect {
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Value("${spring.application.name}")
    private String appName;

    // 切入点
    @Pointcut("execution(* com.amur.home.msg.controller.*.*(..))")
    public void controllerPointCut() {}

    // 前置通知
    @Before("controllerPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        // 记录请求开始时间
        startTime.set(System.currentTimeMillis());

        // 接收请求, 记录请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 记录请求内容
        log.info("[{}][HTTP调用][{}]{} [req]{} -> {}",appName,request.getMethod(),request.getRequestURL().toString(),Arrays.toString(joinPoint.getArgs()),joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    // 返回通知
    @AfterReturning(returning = "result", pointcut = "controllerPointCut()")
    public void doAfterReturning(Object result) {
        // 请求返回内容
        log.info("[{}][HTTP返回][resp]{{}} [耗时]{}ms",appName,result,System.currentTimeMillis() - startTime.get());
        // 用完之后移除, 避免内存泄漏
        startTime.remove();
    }

    // 异常通知
    @AfterThrowing(value = "controllerPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        // 获取类名加方法名
        String name = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        // 记录异常信息
        log.info("[HTTP调用异常] {}, [异常消息] {}", name, e.getMessage());
    }

}
