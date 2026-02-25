package com.paradigma0621.rabbitmqpoc1.entity;

import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private UUID id = UUID.randomUUID();
    private String name;
    private Double price;
}
