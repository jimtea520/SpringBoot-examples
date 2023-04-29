package com.example.validationdemo.controller;

/**
 * @author fking
 * @date 2023-04-29 23:00
 */

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * 統一异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest request, Exception exception) throws Exception {
        log.error(exception.getMessage(), exception);
        String result="";
        if (exception instanceof BindException){
            result = "参数错误 - " + Objects.requireNonNull(((BindException) exception).getFieldError()).getDefaultMessage();
        }else {
            result = "服务器异常";
        }
        return result;
    }
}