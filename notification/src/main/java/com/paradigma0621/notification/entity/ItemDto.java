package com.paradigma0621.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {
    private UUID id = UUID.randomUUID();
    private ProductDto productDto;
    private Integer quanity;
}
