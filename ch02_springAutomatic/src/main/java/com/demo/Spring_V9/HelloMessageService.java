package com.demo.Spring_V9;

import org.springframework.stereotype.Service;

/**
 * @author Aurora
 * @date 2025年12月31日 21:28
 */
public class HelloMessageService implements MessageService {

    @Override
    public String getMessage() {


        return "Hi from HiMessageService!";
    }
}
