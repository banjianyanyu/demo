package com.bjyy.ch14_springboot_developingtips.ifswitchreconstruction.strategypattern;

public interface NotificationStrategy {
    void send(String message);
}