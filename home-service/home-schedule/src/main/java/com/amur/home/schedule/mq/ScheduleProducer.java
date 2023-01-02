package com.amur.home.schedule.mq;

import com.amur.home.schedule.config.RabbitMQConfig;
import com.amur.home.schedule.entity.Schedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ScheduleProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Schedule schedule) {
        log.info("send message: " + schedule.toString());
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, RabbitMQConfig.ROUTING_KEY, schedule);
    }
}
