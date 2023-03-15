package com.amur.home.msg.exception;

import com.amur.home.util.ServiceResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ServiceResult<?> handleException(Exception e) {
        return ServiceResult.fail(e.getMessage());
    }
}
