package com.bjyy.ch06_springboot_mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjyy.ch06_springboot_mybatisplus.mapper.UserMapper;
import com.bjyy.ch06_springboot_mybatisplus.pojo.User;
import com.bjyy.ch06_springboot_mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Aurora
 * @date 2026年01月09日 22:37
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    public IPage<User> getUserPage(int pageNum, int pageSize) {
        // 创建分页对象
        Page<User> page = new Page<>(pageNum, pageSize);

        // 调用 selectPage 方法进行分页查询
        return userMapper.selectPage(page, null); // null = 没有条件
    }
}
