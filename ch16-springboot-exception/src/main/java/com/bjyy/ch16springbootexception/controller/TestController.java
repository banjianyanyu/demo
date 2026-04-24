package com.bjyy.ch16springbootexception.controller;

import com.bjyy.ch16springbootexception.common.ApiResponse;
import com.bjyy.ch16springbootexception.common.CommonErrorCode;
import com.bjyy.ch16springbootexception.exception.BusinessException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 业务异常
     */
    @GetMapping("/business-error")
    public ApiResponse<String> businessError() {
        throw new BusinessException(CommonErrorCode.BUSINESS_ERROR);
    }

    /**
     * 系统异常（空指针）
     */
    @GetMapping("/null-error")
    public ApiResponse<String> nullError() {
        String str = null;
        str.length(); // NPE
        return ApiResponse.success("ok");
    }


    /**
     * 普通异常
     */
    @GetMapping("/runtime-error")
    public ApiResponse<String> runtimeError() {
        throw new RuntimeException("未知运行时异常");
    }

    /**
     * 正常请求
     */
    @GetMapping("/success")
    public ApiResponse<String> success() {
        return ApiResponse.success("ok");
    }



    /**
     * ❌ 错误示例：直接吞异常（不推荐）
     */
    @GetMapping("/try-bad")
    public ApiResponse<String> tryBad() {
        try {
            int a = 1 / 0;
            return ApiResponse.success("ok");
        } catch (Exception e) {
            // ❌ 不推荐：丢失异常体系
            return ApiResponse.fail("99999", "系统异常");
        }
    }
    /**
     * ✅ 推荐：catch 后重新抛业务异常
     */
    @GetMapping("/try-good")
    public ApiResponse<String> tryGood() {
        try {
            int a = 1 / 0;
            return ApiResponse.success("ok");
        } catch (Exception e) {
            throw new BusinessException(
                    CommonErrorCode.SYSTEM_ERROR.getCode(),
                    "计算异常"
            );
        }
    }

    /**
     * ✅ 推荐2：包装成运行时异常交给全局处理
     */
    @GetMapping("/try-runtime")
    public ApiResponse<String> tryRuntime() {
        try {
            String str = null;
            str.length();
            return ApiResponse.success("ok");
        } catch (Exception e) {
            throw new RuntimeException("内部运行异常", e);
        }
    }
}