package com.paradigma0621.notification.service;

import com.paradigma0621.notification.entity.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(OrderDto order) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("orders-api@company.com");
        simpleMailMessage.setTo(order.getNotificationEmail());
        simpleMailMessage.setSubject("Pedido de Compra");
        simpleMailMessage.setText(this.getMessage(order));
        mailSender.send(simpleMailMessage);
    }

    private String getMessage(OrderDto pedido) {
        String client = pedido.getClient();
        String orderId = pedido.getId().toString();
        String totalAmont = String.valueOf(pedido.getTotalAmount());
        String status = pedido.getStatus().name();

        return String.format("Hello, %s! Your order number %s, totaling %s, has been successfully completed.\n" +
                             "Status: %s.", client, orderId, totalAmont, status);
    }

}