package com.paradigma0621.notification.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.paradigma0621.notification.entity.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private UUID id = UUID.randomUUID();
    private String client;
    private List<ItemDto> itemDtos = new ArrayList<>();
    private Double totalAmount;
    private String notificationEmail;
    private StatusEnum status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerDate = LocalDateTime.now();
}
