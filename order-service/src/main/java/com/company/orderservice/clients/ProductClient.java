package com.company.orderservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", path = "/api/product")
public interface ProductClient {

    @GetMapping("check/{id}")
    boolean checkProductExists(@PathVariable long id);

    @GetMapping("/price/{id}")
    double getProductPriceById(@PathVariable long id);

}
