package com.tienhuynh_tn.stockservice.kafka;

import com.tienhuynh_tn.basedomains.dto.order.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerKafka {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumerKafka.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order event received in stock service by Kafka => %s", orderEvent.toString()));

        // Save the order event into the database
        // TODO
    }
}
