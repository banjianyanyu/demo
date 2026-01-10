package com.bjyy.ch10_java_proxy.proxy.JavaProxy;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {

    private final Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("【前置日志】方法：" + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("【后置日志】方法：" + method.getName());
        return result;
    }
}
