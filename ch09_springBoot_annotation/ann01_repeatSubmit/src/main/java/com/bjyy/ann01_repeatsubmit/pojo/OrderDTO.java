package com.bjyy.ann01_repeatsubmit.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDTO {

    private String orderNo;
    private BigDecimal amount;
}
