package com.example.productservice.product;

import com.example.productservice.product.dtos.ProductCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductCheckService checkService;
    private final ProductMapper mapper;

    public List<Product> getAll() {
        return repository.findAll();
    }

    public long create(ProductCreateDto dto) {
        checkService.checkOnCreate(dto);
        Product product = mapper.fromDto(dto);
        repository.save(product);
        return product.getId();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public boolean isExist(long id) {
        return repository.existsById(id);
    }

    public double getPrice(long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Product not found!");
        }).getPrice();
    }
}
