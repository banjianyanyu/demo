package com.bjyy.ch12_java_design.singleton_pattern;

/**
 *@Author：Aurora
 *@Date：2026/1/10
 *@Description:2、懒汉式，线程安全
 *
 */

public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){}
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {  
            instance = new LazySingleton();
        }  
        return instance;  
    }  
}