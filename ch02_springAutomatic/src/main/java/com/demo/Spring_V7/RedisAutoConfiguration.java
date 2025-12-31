package com.demo.Spring_V7;

import com.demo.Spring_V3.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aurora
 * @date 2025年12月31日 21:07
 */
@Configuration
public class RedisAutoConfiguration {
    @Bean
    public UserService userService(){
        return new UserService();
    }
}
