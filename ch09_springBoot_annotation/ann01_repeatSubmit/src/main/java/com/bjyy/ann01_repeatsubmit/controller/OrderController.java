package com.bjyy.ann01_repeatsubmit.controller;

import com.bjyy.ann01_repeatsubmit.annotation.RepeatSubmit;
import com.bjyy.ann01_repeatsubmit.pojo.OrderDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/submit")
    @RepeatSubmit(interval = 30, message = "请勿重复提交订单")
    public String submit(@RequestBody OrderDTO dto) {
        return "订单提交成功：" + dto.getOrderNo();
    }
}
