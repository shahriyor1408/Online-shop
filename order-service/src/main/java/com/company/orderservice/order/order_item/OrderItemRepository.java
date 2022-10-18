package com.company.orderservice.order.order_item;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query(value = "from OrderItem where orderId = :orderId")
    List<OrderItem> getAll(@NonNull @Param(value = "orderId") long id);
}
