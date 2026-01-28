package com.bjyy.ch14_springboot_developingtips.demo03jacksonviews;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {

    @JsonView(Views.Base.class)
    private Long id;

    @JsonView(Views.Base.class)
    private String username;

    @JsonView(Views.Detail.class)
    private String email;

    @JsonView(Views.Detail.class)
    private String phone;

    @JsonView(Views.Admin.class)
    private BigDecimal salary;

    // getter / setter
}
