package com.bjyy.springaialibabaquickstart.controller;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aurora
 * @date 2026年01月31日 8:14
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/wrold")
    public String messageChatMemoryAdvisor() {

        return "Hello World3333";
    }
}
