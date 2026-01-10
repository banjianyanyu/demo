package com.bjyy.ch10_java_proxy.proxy.CGLIBProxy;

public class OrderService {

    public void create(String orderNo) {
        System.out.println("创建订单：" + orderNo);
    }
}
