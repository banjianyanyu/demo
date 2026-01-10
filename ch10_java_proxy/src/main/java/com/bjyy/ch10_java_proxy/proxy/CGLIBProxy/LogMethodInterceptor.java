package com.bjyy.ch10_java_proxy.proxy.CGLIBProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj,
                            Method method,
                            Object[] args,
                            MethodProxy proxy) throws Throwable {

        System.out.println("【CGLIB 前置】" + method.getName());
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("【CGLIB 后置】" + method.getName());
        return result;
    }
}
