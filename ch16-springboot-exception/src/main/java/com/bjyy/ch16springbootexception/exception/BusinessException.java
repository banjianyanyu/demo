package com.bjyy.ch16springbootexception.exception;

import com.bjyy.ch16springbootexception.common.CommonErrorCode;
import lombok.Data;

public class BusinessException extends RuntimeException {

    private final String code;
    private final String message;

    public BusinessException(CommonErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}