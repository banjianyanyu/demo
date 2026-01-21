package com.bjyy.ch14_springboot_developingtips.ifswitchreconstruction.strategypattern;

import org.springframework.stereotype.Component;

@Component("SMS")
public class SmsNotificationStrategy implements NotificationStrategy {
    public void send(String message) {
        System.out.println("发送短信: " + message);
    }
}