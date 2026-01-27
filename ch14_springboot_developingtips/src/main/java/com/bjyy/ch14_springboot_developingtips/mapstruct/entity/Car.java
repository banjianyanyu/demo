package com.bjyy.ch14_springboot_developingtips.mapstruct.entity;

import com.bjyy.ch14_springboot_developingtips.mapstruct.enumType.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aurora
 * @date 2026年01月27日 12:55
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String make;
    private int numberOfSeats;
    private CarType type;

}