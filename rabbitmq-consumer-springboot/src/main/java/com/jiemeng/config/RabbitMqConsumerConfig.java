package com.jiemeng.config;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class RabbitMqConsumerConfig {
    @RabbitHandler
    public void receivel(String message){
        System.out.println("message:"+message);
    }
}
