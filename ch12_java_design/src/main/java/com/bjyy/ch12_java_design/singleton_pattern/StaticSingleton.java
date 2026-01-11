package com.bjyy.ch12_java_design.singleton_pattern;
/**
 *@Author：Aurora
 *@Date：2026/1/10
 *@Description:5、登记式/静态内部类
 *
 */

public class StaticSingleton {
    private static class SingletonHolder {  
    private static final StaticSingleton INSTANCE = new StaticSingleton();
    }  
    private StaticSingleton(){}
    public static final StaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;  
    }  
}