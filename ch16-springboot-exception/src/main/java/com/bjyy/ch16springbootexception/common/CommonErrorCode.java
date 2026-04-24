package com.bjyy.ch16springbootexception.common;

public enum CommonErrorCode {

    SYSTEM_ERROR("10000", "系统异常"),
    PARAM_ERROR("10001", "参数错误"),
    BUSINESS_ERROR("10002", "业务异常"),
    NOT_FOUND("10003", "资源不存在");

    private final String code;
    private final String msg;

    CommonErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}