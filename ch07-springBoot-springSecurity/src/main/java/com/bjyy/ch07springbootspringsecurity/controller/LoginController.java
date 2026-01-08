package com.bjyy.ch07springbootspringsecurity.controller;

import com.bjyy.ch07springbootspringsecurity.doto.User;
import com.bjyy.ch07springbootspringsecurity.service.LoginServcie;
import com.bjyy.ch07springbootspringsecurity.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
 
    @Autowired
    private LoginServcie loginServcie;
 
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return loginServcie.login(user);
    }
}
 