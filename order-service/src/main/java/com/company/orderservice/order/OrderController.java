package com.company.orderservice.order;

import com.company.orderservice.order.dtos.OrderDetails;
import com.company.orderservice.order.dtos.OrderItemCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping("/basket")
    public ResponseEntity<OrderDetails> get() {
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDetails>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/addToBasket")
    public ResponseEntity<Long> create(@RequestBody @Valid OrderItemCreateDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }


}
