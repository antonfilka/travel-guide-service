package com.example.travelguideservice.dto.order;


import com.example.travelguideservice.model.order.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {

    private Long id;
    private Long petId;
    private Integer quantity;
    private LocalDateTime shipDate;
    private OrderStatus status;
    private boolean complete;
}
