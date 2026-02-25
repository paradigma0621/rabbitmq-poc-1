package com.paradigma0621.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private UUID id = UUID.randomUUID();
    private String name;
    private Double price;
}
