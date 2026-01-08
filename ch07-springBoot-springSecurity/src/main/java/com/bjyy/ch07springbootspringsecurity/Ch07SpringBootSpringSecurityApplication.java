package com.bjyy.ch07springbootspringsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.bjyy.ch07springbootspringsecurity.mapper")
public class Ch07SpringBootSpringSecurityApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Ch07SpringBootSpringSecurityApplication.class, args);
        System.out.println("1");
    }

}
