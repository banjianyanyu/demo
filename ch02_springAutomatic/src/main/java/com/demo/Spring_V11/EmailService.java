    package com.demo.Spring_V11;

    /**
 * @author Aurora
 * @date 2025年12月31日 21:28
 */
    public class EmailService implements MessageService {
        @Override
        public void send(String message) {


            System.out.println("Sending Email: " + message);
        }
}
