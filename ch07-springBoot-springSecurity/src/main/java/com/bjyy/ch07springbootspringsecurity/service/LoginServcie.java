package com.bjyy.ch07springbootspringsecurity.service;


import com.bjyy.ch07springbootspringsecurity.doto.User;
import com.bjyy.ch07springbootspringsecurity.util.ResponseResult;

public interface LoginServcie {
    ResponseResult login(User user);


}
