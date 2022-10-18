package com.example.productservice.product.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDto {

    @NotBlank(message = "Name can not be blank!")
    private String name;

    @NotNull(message = "Price can not be null!")
    private Double price;

    @NotNull(message = "Count can not be null!")
    private Integer count;

    @NotNull(message = "User id can not be null!")
    private Long userId;
}
