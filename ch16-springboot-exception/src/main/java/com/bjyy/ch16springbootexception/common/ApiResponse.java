package com.bjyy.ch16springbootexception.common;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private String code;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> r = new ApiResponse<>();
        r.setCode("0");
        r.setMessage("SUCCESS");
        r.setData(data);
        return r;
    }

    public static <T> ApiResponse<T> fail(String code, String msg) {
        ApiResponse<T> r = new ApiResponse<>();
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }
}