package com.tienhuynh_tn.orderservice.rabbitmq;

import com.tienhuynh_tn.basedomains.dto.order.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerRabbitMQ {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducerRabbitMQ.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.routing.key.email}")
    private String orderEmailRoutingKey;

    private RabbitTemplate rabbitTemplate;

    public OrderProducerRabbitMQ(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order event sent to RabbitMQ => %s", orderEvent.toString()));
        rabbitTemplate.convertAndSend(exchange, orderEmailRoutingKey, orderEvent);
    }
}
