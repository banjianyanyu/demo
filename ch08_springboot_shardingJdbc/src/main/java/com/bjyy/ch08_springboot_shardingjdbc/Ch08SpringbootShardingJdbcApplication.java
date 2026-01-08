package com.bjyy.ch08_springboot_shardingjdbc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Ch08SpringbootShardingJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch08SpringbootShardingJdbcApplication.class, args);
    }

}
