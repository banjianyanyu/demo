package com.demo.Spring_V9;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aurora
 * @date 2025年12月31日 22:01
 */
@Configuration
public class MessageServiceConfig {

    @Bean
    public HelloMessageService helloMessageService() {


        return new HelloMessageService();
    }

    @Bean
    public HiMessageService hiMessageService() {


        return new HiMessageService();
    }

    @Bean
    public static MessageServicePostProcessor messageServicePostProcessor() {
        return new MessageServicePostProcessor();
    }
}
