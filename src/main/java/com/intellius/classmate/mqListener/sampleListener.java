package com.intellius.classmate.mqListener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
public class sampleListener {
//    @RabbitListener(queues = "sample.queue")
//    public void receiveMessage(final Message message) {
//        System.out.println("sampleListener.receiveMessage");
//        System.out.println(message.toString());
//    }
}
