package com.company.orderservice.order.order_item;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long productId;

    @Column(nullable = false)
    private long orderId;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private Integer quantity;
}
