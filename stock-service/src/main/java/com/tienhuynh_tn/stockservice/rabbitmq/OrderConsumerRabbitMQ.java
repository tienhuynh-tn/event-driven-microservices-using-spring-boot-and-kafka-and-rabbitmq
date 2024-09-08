package com.tienhuynh_tn.stockservice.rabbitmq;

import com.tienhuynh_tn.basedomains.dto.order.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerRabbitMQ {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumerRabbitMQ.class);

    @RabbitListener(queues = "${rabbitmq.queue.name.stock}")
    public void consume(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order event received in stock service by RabbitMQ => %s", orderEvent.toString()));

        // Save the order event into the database
        // TODO
    }
}
