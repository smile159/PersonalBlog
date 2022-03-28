package com.xinxin.config.exception;

import com.xinxin.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public Result<String> handleValidatedException(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            // BeanValidation exception
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            log.error("MethodArgumentNotValidException参数校验异常");
            ex.getFieldErrors().forEach(error -> {
                String field = error.getField();
                Object value = error.getRejectedValue();
                String msg = error.getDefaultMessage();
                log.error(String.format("错误字段 -> %s 错误值 -> %s 原因 -> %s", field, value, msg));
            });
            return Result.error(HttpStatus.BAD_REQUEST.value(), ex.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("; ")));
        } else if (e instanceof ConstraintViolationException) {
            // BeanValidation GET simple param
            log.error("ConstraintViolationException参数校验异常");
            ConstraintViolationException ex = (ConstraintViolationException) e;
            return Result.error(HttpStatus.BAD_REQUEST.value(), ex.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("; ")));
        } else {
            // BeanValidation GET object param
            log.error("CBindException参数校验异常");
            BindException ex = (BindException) e;
            return Result.error(HttpStatus.BAD_REQUEST.value(), ex.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("; ")));
        }
    }
}
