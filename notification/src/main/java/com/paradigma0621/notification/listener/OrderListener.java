package com.paradigma0621.notification.listener;

import com.paradigma0621.notification.entity.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener {

   @RabbitListener(queues = "orders-created-notification")
    public void sendNotification(OrderDto orderDto) {
        log.info("Created Notification: {}", orderDto.toString());
    }

}