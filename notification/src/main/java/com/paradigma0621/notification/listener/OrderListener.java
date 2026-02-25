package com.paradigma0621.notification.listener;

import com.paradigma0621.notification.entity.OrderDto;
import com.paradigma0621.notification.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class OrderListener {

    private final EmailService emailService;

   @RabbitListener(queues = "orders-created-notification")
    public void sendNotification(OrderDto orderDto) {
       if (orderDto.getTotalAmount() > 999_999_999D) {
           log.error("Trying to process with error");
           throw new RuntimeException("Too expensive"); // Force an exception to simulate a system error
                                                        // This will cause the message to be requeued indefinitely
       }

        emailService.sendEmail(orderDto);
        log.info("Created Notification: {}", orderDto);
    }

}