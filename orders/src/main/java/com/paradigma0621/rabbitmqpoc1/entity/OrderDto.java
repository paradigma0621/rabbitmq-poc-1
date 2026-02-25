package com.paradigma0621.rabbitmqpoc1.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.paradigma0621.rabbitmqpoc1.entity.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    @JsonProperty(access = Access.READ_ONLY)
    private UUID id = UUID.randomUUID();
    private String client;
    private List<ItemDto> itemDtos = new ArrayList<>();
    private Double totalAmount;
    private String notificationEmail;
    private StatusEnum status;
    @JsonProperty(access = Access.READ_ONLY)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerDate = LocalDateTime.now();
}
