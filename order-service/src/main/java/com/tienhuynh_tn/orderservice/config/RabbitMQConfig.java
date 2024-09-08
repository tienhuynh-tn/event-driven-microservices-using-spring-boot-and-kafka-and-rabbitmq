package com.tienhuynh_tn.orderservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.queue.name.email}")
    private String orderEmailQueue;

    @Value("${rabbitmq.queue.name.stock}")
    private String orderStockQueue;

    @Value("${rabbitmq.binding.routing.key.email}")
    private String orderEmailRoutingKey;

    @Value("${rabbitmq.binding.routing.key.stock}")
    private String orderStockRoutingKey;

    // Spring bean for exchange
    @Bean
    public Exchange exchange() {
        return new TopicExchange(exchange);
    }

    // Spring bean for queue - order queue
    @Bean
    public Queue orderEmailQueue() {
        return new Queue(orderEmailQueue);
    }

    @Bean
    public Queue orderStockQueue() {
        return new Queue(orderStockQueue);
    }

    // Spring bean for binding between exchange and queue using routing key
    @Bean
    public Binding orderEmailBinding() {
        return BindingBuilder
                .bind(orderEmailQueue())
                .to(exchange())
                .with(orderEmailRoutingKey).noargs();
    }

    @Bean
    public Binding orderStockBinding() {
        return BindingBuilder
                .bind(orderEmailQueue())
                .to(exchange())
                .with(orderStockRoutingKey).noargs();
    }

    // Message converter
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    // Configure RabbitTemplate
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
