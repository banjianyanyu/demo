package com.bjyy.ch13_springboot_satoken;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch13SpringbootSaTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch13SpringbootSaTokenApplication.class, args);
        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
    }

}
