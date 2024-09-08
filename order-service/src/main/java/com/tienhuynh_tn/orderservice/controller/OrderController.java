package com.tienhuynh_tn.orderservice.controller;

import com.tienhuynh_tn.basedomains.dto.order.Order;
import com.tienhuynh_tn.basedomains.dto.order.OrderEvent;
import com.tienhuynh_tn.orderservice.kafka.OrderProducerKafka;
import com.tienhuynh_tn.orderservice.rabbitmq.OrderProducerRabbitMQ;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducerKafka orderProducerKafka;

    private OrderProducerRabbitMQ orderProducerRabbitMQ;

    public OrderController(OrderProducerKafka orderProducerKafka, OrderProducerRabbitMQ orderProducerRabbitMQ) {
        this.orderProducerKafka = orderProducerKafka;
        this.orderProducerRabbitMQ = orderProducerRabbitMQ;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {

        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in PENDING state");
        orderEvent.setOrder(order);

        orderProducerKafka.sendMessage(orderEvent);
        orderProducerRabbitMQ.sendMessage(orderEvent);

        return "Order placed successfully...";
    }
}
