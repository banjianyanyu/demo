package com.bjyy.ch12_java_design.singleton_pattern;

/**
 *@Author：Aurora
 *@Date：2026/1/10
 *@Description:1、懒汉式，线程不安全
 *
 */

public class Singleton {
    private static Singleton instance;  
    private Singleton (){}  
  
    public static Singleton getInstance() {  
        if (instance == null) {  
            instance = new Singleton();  
        }  
        return instance;  
    }  
}