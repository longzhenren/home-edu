package com.amur.home.msg.mq;

import com.amur.home.msg.config.RabbitMQConfig;
import com.amur.home.schedule.entity.Schedule;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RabbitMQService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {

    }

    @RabbitListener(queues = RabbitMQConfig.DIRECT_QUEUE)
    public void receiveScheduleMessage(Schedule schedule) {
        System.out.println("receive schedule message: " + schedule.toString());
        sendMessage(schedule.toString());
    }
}

