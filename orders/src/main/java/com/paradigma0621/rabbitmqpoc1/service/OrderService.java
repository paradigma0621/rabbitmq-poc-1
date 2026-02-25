package com.paradigma0621.rabbitmqpoc1.service;

import com.paradigma0621.rabbitmqpoc1.entity.OrderDto;
import com.paradigma0621.rabbitmqpoc1.entity.enums.StatusEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    public OrderDto requestOrder(OrderDto orderDto) {
        orderDto.setStatus(StatusEnum.PROCESSING);
        rabbitTemplate.convertAndSend(exchangeName, "", orderDto);
        log.info("Order requested: {}", orderDto);
        return orderDto;
    }
}
