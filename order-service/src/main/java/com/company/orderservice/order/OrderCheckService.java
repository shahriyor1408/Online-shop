package com.company.orderservice.order;

import com.company.orderservice.clients.UserClient;
import com.company.orderservice.order.dtos.OrderItemCreateDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCheckService {

    private final UserClient userClient;
    private final OrderRepository repository;

    public void checkOnCreate(@NonNull OrderItemCreateDto dto) {
        if (!userClient.checkUserExists(dto.getUserId())) {
            throw new RuntimeException("User not found");
        }
    }

    public boolean checkExist() {
        return repository.get() == null;
    }
}
