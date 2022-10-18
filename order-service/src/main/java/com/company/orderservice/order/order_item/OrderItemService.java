package com.company.orderservice.order.order_item;

import com.company.orderservice.clients.ProductClient;
import com.company.orderservice.order.dtos.OrderItemCreateDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository repository;
    private final OrderItemCheckService checkService;

    private final ProductClient productClient;

    public void create(@NonNull OrderItemCreateDto dto, @NonNull long orderId) {
        checkService.checkOnCreate(dto);
        repository.save(OrderItem.builder()
                .orderId(orderId)
                .userId(dto.getUserId())
                .productId(dto.getProductId())
                .quantity(dto.getQuantity())
                .build());
    }

    public List<OrderItem> getByOrderId(@NonNull long id) {
        return repository.getAll(id);
    }

    public double getTotalSum(List<OrderItem> orderItems) {
        double sum = 0;
        for (OrderItem orderItem : orderItems) {
            sum += orderItem.getQuantity() * productClient.getProductPriceById(orderItem.getId());
        }
        return sum;
    }
}
