package com.bjyy.ch14_springboot_developingtips.mapstruct.mapper;

import com.bjyy.ch14_springboot_developingtips.mapstruct.entity.User;
import com.bjyy.ch14_springboot_developingtips.mapstruct.entity.UserEntity;
import com.bjyy.ch14_springboot_developingtips.mapstruct.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@Component
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserVo toUserVo(UserEntity user);
}
