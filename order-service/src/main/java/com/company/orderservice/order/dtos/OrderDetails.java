package com.company.orderservice.order.dtos;

import com.company.orderservice.order.order_item.OrderItem;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetails {
    private long id;
    private long userId;
    private List<OrderItem> orderItems;
    private String orderStatus;
    private LocalDateTime createdAt;
    private double total;
}
