package com.bjyy.ch10_java_proxy.proxy.JavaProxy;

import org.springframework.cglib.proxy.Proxy;

public class JdkProxyDemo {

    public static void main(String[] args) {

        UserService target = new UserServiceImpl();

        UserService proxy = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new LogInvocationHandler(target)
        );

        proxy.save("张三");
    }
}
