package com.bjyy.ch11_springaop.service;

import com.bjyy.ch11_springaop.annotation.LogExecution;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @LogExecution("创建订单")
    public String createOrder(String orderNo) {
        System.out.println("执行业务逻辑，订单号：" + orderNo);
        return "SUCCESS";
    }
}
