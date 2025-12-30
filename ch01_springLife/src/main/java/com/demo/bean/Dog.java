package com.demo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author Aurora
 * @date 2025年12月30日 21:01
 */
public class Dog implements BeanFactoryAware , InitializingBean , DisposableBean {
    private String name;

    public Dog() {
        System.out.println("1.实例化");
    }

    public Dog(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2.依赖注入");
        this.name = name;
    }

    public void myInit(){
        System.out.println("6.初始化");
    }

    public void myDestroy(){
        System.out.println("10.Bean销毁");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3.BeanFactoryAware 方法执行了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5.InitializingBean 方法执行了");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("9.DisposableBean 方法执行了");
    }
}
