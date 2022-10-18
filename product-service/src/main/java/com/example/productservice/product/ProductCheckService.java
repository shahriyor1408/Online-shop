package com.example.productservice.product;

import com.example.productservice.product.clients.UserClient;
import com.example.productservice.product.dtos.ProductCreateDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCheckService {

    private final UserClient userClient;

    public void checkOnCreate(@NonNull ProductCreateDto dto) {
        if (!userClient.checkUserExists(dto.getUserId())) {
            throw new RuntimeException("User not found");
        }
    }
}
