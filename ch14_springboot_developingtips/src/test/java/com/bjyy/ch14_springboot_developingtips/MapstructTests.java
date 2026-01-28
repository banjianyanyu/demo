package com.bjyy.ch14_springboot_developingtips;

import com.bjyy.ch14_springboot_developingtips.mapstruct.entity.Car;
import com.bjyy.ch14_springboot_developingtips.mapstruct.entity.User;
import com.bjyy.ch14_springboot_developingtips.mapstruct.entity.UserEntity;
import com.bjyy.ch14_springboot_developingtips.mapstruct.enumType.CarType;
import com.bjyy.ch14_springboot_developingtips.mapstruct.mapper.CarMapper;
import com.bjyy.ch14_springboot_developingtips.mapstruct.mapper.UserConverter;
import com.bjyy.ch14_springboot_developingtips.mapstruct.mapper.UserMapper;
import com.bjyy.ch14_springboot_developingtips.mapstruct.vo.CarDto;
import com.bjyy.ch14_springboot_developingtips.mapstruct.vo.UserDTO;
import com.bjyy.ch14_springboot_developingtips.mapstruct.vo.UserVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MapstructTests {

    @Autowired
    private UserMapper userMapper ;
    @Autowired
    private UserConverter userConverter ;
    @Test
    void voDemo() {
        UserEntity userEntity = new UserEntity("zhangsan", 18);
        UserVo userVo = userMapper.INSTANCE.toUserVo(userEntity);
        System.out.println(userVo);
    }


    @Test
    public void testBasicTypeConvert() {
        Car car = new Car("artisan", 7, CarType.BMW);
        CarDto cardto = CarMapper.INSTANCE.carToCarDto(car);

        System.out.println(car);
        System.out.println(cardto);

        Assertions.assertEquals(car.getNumberOfSeats(), cardto.getSeatCount());
    }

    /**
     *@Author：Aurora
     *@Date：2026/1/27
     *@Description: 1、处理字段名不一致
     *
     */
    @Test
    public void testTypeConvert1() {
        User user = new User(1L, "zhangsan");
        UserDTO dto = userConverter.toDTO(user);

        System.out.println(user);
        System.out.println(dto);
    }

    @Test
    public void testEntityList() {
        UserDTO userDTO1 = new UserDTO(1L, "zhangsan");
        UserDTO userDTO2 = new UserDTO(2L, "lisi");

        List<UserDTO> dto = new ArrayList<>();
        dto.add(userDTO1);
        dto.add(userDTO2);
        List<User> user = userConverter.toEntityList(dto);
        for (User user1 : user) {
            System.out.println(user1);

        }

    }
}
