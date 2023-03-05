package com.amur.home.msg.mq;

import com.amur.home.msg.config.RabbitMQConfig;
import com.amur.home.msg.ws.WebSocketService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RabbitMQService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        for (WebSocketService webSocketService : WebSocketService.webSockets) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, RabbitMQConfig.ROUTING_KEY, message + " (" + webSocketService.toString() + ")");
        }
        rabbitTemplate.convertAndSend("myQueue", message);
    }

    @RabbitListener(queues = "direct_queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}

