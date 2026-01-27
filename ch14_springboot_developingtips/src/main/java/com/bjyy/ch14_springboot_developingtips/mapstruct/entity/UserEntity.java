package com.bjyy.ch14_springboot_developingtips.mapstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UserEntity {

    private String username;

    private Integer age;

}
