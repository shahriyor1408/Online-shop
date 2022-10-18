package com.company.orderservice.order.order_item;

import com.company.orderservice.clients.ProductClient;
import com.company.orderservice.order.dtos.OrderItemCreateDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemCheckService {

    private final ProductClient client;

    public void checkOnCreate(@NonNull OrderItemCreateDto dto) {
        if (!client.checkProductExists(dto.getUserId())) {
            throw new RuntimeException("User not found");
        }
    }
}
