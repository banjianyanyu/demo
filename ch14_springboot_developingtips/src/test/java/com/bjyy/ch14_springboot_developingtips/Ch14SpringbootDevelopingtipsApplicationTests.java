package com.bjyy.ch14_springboot_developingtips;

import com.bjyy.ch14_springboot_developingtips.demo01ifswitchreconstruction.operation.Operation;
import com.bjyy.ch14_springboot_developingtips.demo01ifswitchreconstruction.strategypattern.NotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ch14SpringbootDevelopingtipsApplicationTests {

    @Autowired
    private NotificationService notificationService;
    @Test
    void strategyDemo() {
        notificationService.notify("EMAIL", "你好");
    }

    @Test
    void operationDemo() {
        int result = Operation.MUL.apply(2, 3); // 输出 6
        System.out.println(result);
    }
}
