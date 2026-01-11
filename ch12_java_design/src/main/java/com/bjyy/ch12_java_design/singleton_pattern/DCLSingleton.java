package com.bjyy.ch12_java_design.singleton_pattern;

/**
 *@Author：Aurora
 *@Date：2026/1/10
 *@Description:4、双检锁/双重校验锁（DCL，即 double-checked locking）
 *
 */

public class DCLSingleton {
    private volatile static DCLSingleton singleton;
    private DCLSingleton(){}
    public static DCLSingleton getSingleton() {
    if (singleton == null) {  
        synchronized (DCLSingleton.class) {
            if (singleton == null) {  
                singleton = new DCLSingleton();
            }  
        }  
    }  
    return singleton;  
    }  
}