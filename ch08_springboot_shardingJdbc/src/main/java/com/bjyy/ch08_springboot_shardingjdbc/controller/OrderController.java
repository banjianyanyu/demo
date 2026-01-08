package com.bjyy.ch08_springboot_shardingjdbc.controller;

import com.bjyy.ch08_springboot_shardingjdbc.mapper.OrderMapper;
import com.bjyy.ch08_springboot_shardingjdbc.pojo.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;

    @GetMapping("/add")
    public String add(@RequestParam Long userId) {
        Order order = new Order();
        order.setOrderId(System.currentTimeMillis());
        order.setUserId(userId);
        order.setAmount(BigDecimal.valueOf(100));
        order.setStatus("SUCCESS");

        orderMapper.insert(order);
        return "ok";
    }

    @GetMapping("/list")
    public List<Order> list(@RequestParam Long userId) {
        return orderMapper.selectByUserId(userId);
    }

    @GetMapping("/listAll")
    public List<Order> listAll() {
        return orderMapper.listAll();
    }
}
