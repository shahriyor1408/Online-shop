package com.company.orderservice.order.dtos;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemCreateDto {

    @NotNull(message = "Product id can not be null!")
    private long productId;

    @NotNull(message = "Quantity can not be null!")
    private Integer quantity;

    @NotNull(message = "User id can not be null!")
    private long userId;
}
