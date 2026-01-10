package com.bjyy.ch11_springaop.aopdemo;


import com.bjyy.ch11_springaop.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestRunner {

    @Bean
    public CommandLineRunner test(OrderService orderService) {
        return args -> {
            orderService.createOrder("ORDER-1001");
        };
    }
}
