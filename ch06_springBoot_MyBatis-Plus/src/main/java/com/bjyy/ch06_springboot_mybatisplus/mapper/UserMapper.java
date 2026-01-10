package com.bjyy.ch06_springboot_mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjyy.ch06_springboot_mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Insert("insert into user(id,name) values( #{id},#{name})")
    int myInsertWithoutParam(User user);
}