package com.bjyy.ch14_springboot_developingtips.demo01ifswitchreconstruction.strategypattern;

public interface NotificationStrategy {
    void send(String message);
}