package com.company.orderservice.order;

import com.company.orderservice.order.dtos.OrderDetails;
import com.company.orderservice.order.dtos.OrderItemCreateDto;
import com.company.orderservice.order.order_item.OrderItem;
import com.company.orderservice.order.order_item.OrderItemService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderCheckService checkService;
    private final OrderItemService orderItemService;

    public Long create(@NonNull OrderItemCreateDto dto) {
        checkService.checkOnCreate(dto);
        if (checkService.checkExist()) {
            return createOrder(dto);
        } else {
            return addExist(dto);
        }
    }

    private Long addExist(@NonNull OrderItemCreateDto dto) {
        Order order = repository.get();
        orderItemService.create(dto, order.getId());
        return order.getId();
    }

    private Long createOrder(@NonNull OrderItemCreateDto dto) {
        Order order = Order.builder()
                .userId(dto.getUserId())
                .build();
        repository.save(order);
        orderItemService.create(dto, order.getId());
        return order.getId();
    }

    public OrderDetails get() {
        Order order = repository.get();
        if (Objects.isNull(order)) {
            throw new RuntimeException("Order not found!");
        } else {
            return createOrderDetails(order);
        }
    }

    public List<OrderDetails> getAll() {
        List<Order> orders = repository.findAll();
        List<OrderDetails> orderDetails = new ArrayList<>();
        for (Order order : orders) {
            orderDetails.add(createOrderDetails(order));
        }
        return orderDetails;
    }

    private OrderDetails createOrderDetails(Order order) {
        List<OrderItem> orderItems = orderItemService.getByOrderId(order.getId());
        return OrderDetails.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .orderStatus(String.valueOf(order.getOrderStatus()))
                .orderItems(orderItems)
                .createdAt(order.getCreatedAt())
                .total(orderItemService.getTotalSum(orderItems))
                .build();
    }
}
