package com.bjyy.ch14_springboot_developingtips.ifswitchreconstruction.strategypattern;

import org.springframework.stereotype.Component;

@Component("EMAIL")
public class EmailNotificationStrategy implements NotificationStrategy {
    public void send(String message) {
        System.out.println("发送邮件: " + message);
    }
}
