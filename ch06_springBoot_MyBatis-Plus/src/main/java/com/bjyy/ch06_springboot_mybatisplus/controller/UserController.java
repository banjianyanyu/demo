package com.bjyy.ch06_springboot_mybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bjyy.ch06_springboot_mybatisplus.pojo.User;
import com.bjyy.ch06_springboot_mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public IPage<User> getPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        return userService.getUserPage(pageNum, pageSize);
    }
}
