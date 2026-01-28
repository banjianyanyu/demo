package com.bjyy.ch14_springboot_developingtips.demo03jacksonviews;

public class Views {

    // 基础视图
    public interface Base {}

    // 详情视图（继承 Base）
    public interface Detail extends Base {}

    // 管理员视图
    public interface Admin extends Detail {}
}
