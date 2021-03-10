package com.jiemeng;


import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class RabbitmqProducerSpringbootApplicationTests {
    //注入rabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

	@Test
    void testHello() {
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    @Test
    void testWork() {
        for (int i = 0; i <10 ; i++) {
            rabbitTemplate.convertAndSend("work","work模型");
        }
    }
    //fanout广播
    @Test
    void testFanout(){
        rabbitTemplate.convertAndSend("logs","","Fanout的模型发送的消息");
    }
    //route路由模式
    @Test
    void testRoute(){
        rabbitTemplate.convertAndSend("directs","info","发送info的key的路由信息");
    }

    //topic动态路由  订阅模式

    @Test
    void testTopic(){
	    rabbitTemplate.convertAndSend("topics","user.save","user.save 路由消息");
    }
}
