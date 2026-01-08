package com.bjyy.ch07springbootspringsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bjyy.ch07springbootspringsecurity.doto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
