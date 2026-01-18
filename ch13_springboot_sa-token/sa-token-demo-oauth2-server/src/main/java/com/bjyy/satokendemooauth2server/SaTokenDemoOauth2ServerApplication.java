package com.bjyy.satokendemooauth2server;

import cn.dev33.satoken.oauth2.SaOAuth2Manager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaTokenDemoOauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaTokenDemoOauth2ServerApplication.class, args);
        System.out.println("\nSa-Token-OAuth2 Server端启动成功，配置如下：");
    }

}
