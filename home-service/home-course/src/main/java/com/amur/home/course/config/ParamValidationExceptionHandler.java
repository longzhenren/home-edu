package com.amur.home.course.config;


import com.amur.home.common.Constants;
import com.amur.home.util.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ParamValidationExceptionHandler {
    /**
     * 参数统一校验异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper<Void> paramExceptionHandler(MethodArgumentNotValidException e) {
        return ResponseWrapper.fail(Constants.StatusCode.PARAM_MISS, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }
}
