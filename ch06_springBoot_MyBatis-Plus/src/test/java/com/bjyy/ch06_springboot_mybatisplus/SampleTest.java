package com.bjyy.ch06_springboot_mybatisplus;

import com.baomidou.mybatisplus.core.batch.MybatisBatch;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.bjyy.ch06_springboot_mybatisplus.mapper.UserMapper;
import com.bjyy.ch06_springboot_mybatisplus.pojo.User;
import com.bjyy.ch06_springboot_mybatisplus.service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private UserService userService; // 注入 UserService（实际是 UserServiceImpl 实例）
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size(), "");
        userList.forEach(System.out::println);
    }

    //IService 使用
    @Test
    public void testIService() {
        // 假设有一个 User 实体对象
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        boolean result = userService.save(user); // 调用 save 方法
        if (result) {
            System.out.println("User saved successfully.");
        } else {
            System.out.println("Failed to save user.");
        }
    }

    //IService 使用
    @Test
    public void testSaveBatch() {
        // 假设有一组 User 实体对象
//        List<User> users = Arrays.asList(
//                new User("Alice", "alice@example.com"),
//                new User("Bob", "bob@example.com"),
//                new User("Charlie", "charlie@example.com")
//        );
//
//        // 使用默认批次大小进行批量插入
//        boolean result = userService.saveBatch(users); // 调用 saveBatch 方法，默认批次大小
//        if (result) {
//            System.out.println("Users saved successfully.");
//        } else {
//            System.out.println("Failed to save users.");
//        }

        // 假设有一组 User 实体对象
        List<User> users = Arrays.asList(
                new User("David", "david@example.com"),
                new User("Eve", "eve@example.com"),
                new User("Frank", "frank@example.com"),
                new User("Grace", "grace@example.com")
        );
        // 指定批次大小为 2进行批量插入
        boolean result = userService.saveBatch(users, 2); // 调用 saveBatch 方法，指定批次大小
        if (result) {
            System.out.println("Users saved successfully.");
        } else {
            System.out.println("Failed to save users.");
        }
    }
    //示例（page）
    @Test
    public void testPage(){
        // 假设要进行无条件的分页查询，每页显示10条记录，查询第1页
        IPage<User> page = new Page<>(1, 10);
        IPage<User> userPage = userService.page(page); // 调用 page 方法
        List<User> userList = userPage.getRecords();
        long total = userPage.getTotal();
        System.out.println("Total users: " + total);
        for (User user : userList) {
            System.out.println("User: " + user);
        }
    }

    @Test
    public void testQueryWrapper (){
        // 假设有一个 QueryWrapper 对象，设置查询条件为 age > 25，进行有条件的分页查询
        IPage<User> page = new Page<>(1, 10);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 25);
        IPage<User> userPage = userService.page(page, queryWrapper); // 调用 page 方法
        List<User> userList = userPage.getRecords();
        long total = userPage.getTotal();
        System.out.println("Total users (age > 25): " + total);
        for (User user : userList) {
            System.out.println("User: " + user);
        }
    }

    @Test
    public void testUserBatisBatch (){
        List<User> userList = Arrays.asList(new User(2000L, "测试"), new User(2001L, "测试"));
        MybatisBatch<User> mybatisBatch = new MybatisBatch<>(sqlSessionFactory, userList);
        MybatisBatch.Method<User> method = new MybatisBatch.Method<>(UserMapper.class);
        mybatisBatch.execute(method.insert());
    }

    @Test
    public void testmyInsertWithoutParam (){

        // 准备数据
        List<User> h2UserList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            h2UserList.add(new User((long)i, "2"));
        }

        MybatisBatch<User> mybatisBatch = new MybatisBatch<>(sqlSessionFactory, h2UserList);
        MybatisBatch.Method<User> method = new MybatisBatch.Method<>(UserMapper.class);
        mybatisBatch.execute(method.get("myInsertWithoutParam"));
    }
}