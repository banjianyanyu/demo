package com.bjyy.ch06_springboot_mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjyy.ch06_springboot_mybatisplus.pojo.User;

/**
 * @author Aurora
 * @date 2026年01月09日 22:35
 */

public interface  UserService extends IService<User> {
    public IPage<User> getUserPage(int pageNum, int pageSize);
}
