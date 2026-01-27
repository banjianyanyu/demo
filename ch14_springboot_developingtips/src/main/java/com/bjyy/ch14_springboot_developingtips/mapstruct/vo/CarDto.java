package com.bjyy.ch14_springboot_developingtips.mapstruct.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private String make;
    private int seatCount;
    private String type;
}