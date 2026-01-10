package com.bjyy.ch11_springaop.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)      // 作用在方法上
@Retention(RetentionPolicy.RUNTIME) // 运行时可获取
@Documented
public @interface LogExecution {

    /**
     * 业务描述
     */
    String value() default "";
}
