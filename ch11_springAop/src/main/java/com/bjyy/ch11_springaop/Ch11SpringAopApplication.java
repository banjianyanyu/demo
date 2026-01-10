package com.bjyy.ch11_springaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class Ch11SpringAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch11SpringAopApplication.class, args);
    }

}
