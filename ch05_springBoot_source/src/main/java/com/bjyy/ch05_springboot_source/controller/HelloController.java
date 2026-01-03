package com.bjyy.ch05_springboot_source.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aurora
 * @date 2026年01月02日 20:23
 */
@RestController
public class HelloController {

    public HelloController() {
        System.out.println("HelloController...");
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
