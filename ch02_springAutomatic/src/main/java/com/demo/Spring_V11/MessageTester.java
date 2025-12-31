package com.demo.Spring_V11;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Aurora
 * @date 2025年12月31日 22:48
 */
@Component
public class MessageTester {

    @Autowired
    private MessageService messageService;

    @PostConstruct
    public void init() {


        messageService.send("Hello World");
    }
}
