package com.bjyy.ch14_springboot_developingtips.demo01ifswitchreconstruction.strategypattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Aurora
 * @date 2026年01月21日 21:32
 */
@Service
public class NotificationService {
    private final Map<String, NotificationStrategy> strategyMap;

    @Autowired
    public NotificationService(Map<String, NotificationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public void notify(String type, String message) {
        NotificationStrategy strategy = strategyMap.get(type);
        if (strategy != null) {
            strategy.send(message);
        } else {
            throw new IllegalArgumentException("未知通知类型: " + type);
        }
    }
}
