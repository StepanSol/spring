package com.example.controller;

import com.example.model.CreateOrderDTO;
import com.example.model.Order;
import com.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderDTO dto){
        return orderService.createOrder(dto);
    }
}
