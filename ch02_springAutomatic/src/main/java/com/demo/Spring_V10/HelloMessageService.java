package com.demo.Spring_V10;

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
