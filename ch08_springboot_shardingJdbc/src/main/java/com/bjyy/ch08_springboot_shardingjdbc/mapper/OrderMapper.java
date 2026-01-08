package com.bjyy.ch08_springboot_shardingjdbc.mapper;

import com.bjyy.ch08_springboot_shardingjdbc.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO t_order(order_id, user_id, amount, status, create_time)\n" +
            " VALUES (#{orderId}, #{userId}, #{amount}, #{status}, NOW())")
    int insert(Order order);

    @Select("SELECT * FROM t_order WHERE user_id = #{userId}")
    List<Order> selectByUserId(Long userId);

    @Select("SELECT * FROM t_order")
    List<Order> listAll();
}
