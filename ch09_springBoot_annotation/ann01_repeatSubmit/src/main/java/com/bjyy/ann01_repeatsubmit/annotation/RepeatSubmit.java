package com.bjyy.ann01_repeatsubmit.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {

    /**
     * 防重复提交时间（秒）
     */
    int interval() default 30;

    /**
     * 重复提交提示信息
     */
    String message() default "请勿重复提交";
}
