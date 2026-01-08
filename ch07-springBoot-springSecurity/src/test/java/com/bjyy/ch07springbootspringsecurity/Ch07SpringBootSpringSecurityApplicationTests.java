package com.bjyy.ch07springbootspringsecurity;

import com.bjyy.ch07springbootspringsecurity.doto.User;
import com.bjyy.ch07springbootspringsecurity.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class Ch07SpringBootSpringSecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
    @Test
    public void TestBCryptPasswordEncoder(){

//        $2a$10$npv5JSeFR6/wLz8BBMmSBOMb8byg2eyfK4/vvoBk3RKtTLBhIhcpy

        System.out.println(passwordEncoder.
                matches("1234",
                        "$2a$10$npv5JSeFR6/wLz8BBMmSBOMb8byg2eyfK4/vvoBk3RKtTLBhIhcpy"));
//        String encode = passwordEncoder.encode("1234");
//        String encode2 = passwordEncoder.encode("1234");
//        System.out.println(encode);
//        System.out.println(encode2);

    }
}
