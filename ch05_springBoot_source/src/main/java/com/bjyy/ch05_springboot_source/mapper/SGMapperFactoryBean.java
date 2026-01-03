package com.bjyy.ch05_springboot_source.mapper;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @author Aurora
 * @date 2026年01月02日 21:32
 */
public class SGMapperFactoryBean implements FactoryBean {
    private String className;

    public SGMapperFactoryBean(String className) {
        this.className = className;
    }

    @Override
    public Object getObject() throws Exception {
        Class<?> interfaceClass = Class.forName(className);
        //生成动态代理对象返回
        Object proxyInstance = Proxy.newProxyInstance(SGMapperFactoryBean.class.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                return SGMapperFactoryBean.this.invoke(o, method, objects);
            }
        });
        return proxyInstance;
    }

    @Override
    public Class<?> getObjectType() {
        try {
            Class<?> interfaceClass = Class.forName(className);
            return interfaceClass;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object invoke(Object o, Method method, Object[] objects) {
        //判断当前调用的方法是否是select方法
//                System.out.println("ss");
        if ("select".equals(method.getName())) {
            System.out.println(className + "的动态代理对象的select方法被执行了");
        }
        //如果是就再控制台打印
        return null;
    }
}
