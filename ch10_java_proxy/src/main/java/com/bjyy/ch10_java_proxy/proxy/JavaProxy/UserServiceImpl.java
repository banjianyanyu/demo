package com.bjyy.ch10_java_proxy.proxy.JavaProxy;

public class UserServiceImpl implements UserService {
    @Override
    public void save(String name) {
        System.out.println("保存用户：" + name);
    }
}