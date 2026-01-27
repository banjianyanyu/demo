package com.bjyy.ch14_springboot_developingtips.mapstruct.mapper;

import com.bjyy.ch14_springboot_developingtips.mapstruct.entity.Car;
import com.bjyy.ch14_springboot_developingtips.mapstruct.vo.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);
}