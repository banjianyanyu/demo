package com.bjyy.ch14_springboot_developingtips.mapstruct.enumType;

/**
 * @author artisan
 */

public enum CarType {
    BMW(1, "BMW"),
    FLL(2, "FLL");


    private int code;
    private String brand;

    CarType(int code, String brand) {
        this.code = code;
        this.brand = brand;
    }

    public int getCode() {
        return code;
    }

    public String getBrand() {
        return brand;
    }

    // 根据code获取brand的方法
    public static String getBrandByCode(int code) {
        for (CarType carType : CarType.values()) {
            if (carType.getCode() == code) {
                return carType.getBrand();
            }
        }
        return null; // 如果code不存在，则返回null或其他默认值
    }
}