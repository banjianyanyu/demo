package com.bjyy.ch10_java_proxy.proxy.CGLIBProxy;

import org.springframework.cglib.proxy.Enhancer;

public class CglibProxyDemo {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderService.class);
        enhancer.setCallback(new LogMethodInterceptor());

        OrderService proxy = (OrderService) enhancer.create();
        proxy.create("NO123");
    }
}
