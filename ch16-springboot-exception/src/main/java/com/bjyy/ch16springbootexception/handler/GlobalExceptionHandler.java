package com.bjyy.ch16springbootexception.handler;

import com.bjyy.ch16springbootexception.common.ApiResponse;
import com.bjyy.ch16springbootexception.common.CommonErrorCode;
import com.bjyy.ch16springbootexception.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.ObjectError;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ApiResponse<Void> handleBusinessException(BusinessException e) {
        log.warn("BusinessException: code={}, msg={}", e.getCode(), e.getMessage());
        return ApiResponse.fail(e.getCode(), e.getMessage());
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Void> handleValidException(MethodArgumentNotValidException e) {

        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        String msg = error.getDefaultMessage();

        log.warn("Param error: {}", msg);
        return ApiResponse.fail(CommonErrorCode.PARAM_ERROR.getCode(), msg);
    }

    /**
     * 其他未知异常
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> handleException(Exception e) {

        log.error("System error", e);

        return ApiResponse.fail(
                CommonErrorCode.SYSTEM_ERROR.getCode(),
                CommonErrorCode.SYSTEM_ERROR.getMsg()
        );
    }
}