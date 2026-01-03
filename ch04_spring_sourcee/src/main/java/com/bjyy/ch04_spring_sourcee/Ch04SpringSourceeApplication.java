package com.bjyy.ch04_spring_sourcee;

import com.bjyy.ch04_spring_sourcee.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Ch04SpringSourceeApplication {

    public static void main(String[] args) {
        //目标 Bean是怎么创建的，为什么能获取到Bean
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User bean = (User) context.getBean("user");
    }

}
