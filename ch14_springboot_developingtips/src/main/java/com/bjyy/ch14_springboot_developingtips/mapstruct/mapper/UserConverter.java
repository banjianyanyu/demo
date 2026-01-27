package com.bjyy.ch14_springboot_developingtips.mapstruct.mapper;

import com.bjyy.ch14_springboot_developingtips.mapstruct.entity.User;
import com.bjyy.ch14_springboot_developingtips.mapstruct.vo.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserConverter {
//    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);
    
    @Mapping(source = "username", target = "name")
    UserDTO toDTO(User dto);

    List<User> toEntityList(List<UserDTO> users);


    @Mapping(target = "id", defaultValue = "100L")
    User toEntity(UserDTO dto);
}