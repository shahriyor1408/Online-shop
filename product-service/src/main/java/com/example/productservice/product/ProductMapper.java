package com.example.productservice.product;

import com.example.productservice.product.dtos.ProductCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product fromDto(ProductCreateDto dto);
}
