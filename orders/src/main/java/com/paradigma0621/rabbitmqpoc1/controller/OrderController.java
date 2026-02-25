package com.paradigma0621.rabbitmqpoc1.controller;

import com.paradigma0621.rabbitmqpoc1.entity.OrderDto;
import com.paradigma0621.rabbitmqpoc1.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        log.info("Order received: {}", orderDto.toString());
        orderDto = service.requestOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }

}
