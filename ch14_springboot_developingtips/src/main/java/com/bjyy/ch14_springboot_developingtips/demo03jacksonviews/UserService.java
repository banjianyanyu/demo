package com.bjyy.ch14_springboot_developingtips.demo03jacksonviews;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aurora
 * @date 2026年01月28日 12:56
 */
@Service
public class UserService {

    public List<User> list() {
        return Arrays.asList(mockUser());
    }

    public User getById(Long id) {
        return mockUser();
    }

    private User mockUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("tom");
        user.setEmail("tom@test.com");
        user.setPhone("13800000000");
        user.setSalary(new BigDecimal("20000"));
        return user;
    }
}