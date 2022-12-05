package com.amur.home.msg.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String ROUTING_KEY = "AMUR_DIRECT_ROUTING";
    public static final String DIRECT_EXCHANGE = "AMUR_DIRECT_EXCHANGE";
    public static final String DIRECT_QUEUE = "AMUR_DIRECT_QUEUE";

    @Bean
    public Queue directQueue() {
        return new Queue(DIRECT_QUEUE);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(ROUTING_KEY);
    }

}
