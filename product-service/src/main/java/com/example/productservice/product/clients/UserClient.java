package com.example.productservice.product.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", path = "/api/user")
public interface UserClient {

    @GetMapping("check/{id}")
    boolean checkUserExists(@PathVariable long id);

    @GetMapping("/username/{id}")
    String getUserNameByUserID(@PathVariable long id);
}
