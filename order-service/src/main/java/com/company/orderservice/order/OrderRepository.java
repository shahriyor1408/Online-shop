package com.company.orderservice.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "from Order where orderStatus = 'UNPAID'")
    Order get();
}
