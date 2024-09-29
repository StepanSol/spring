package com.example.controller;

import com.example.model.*;
import com.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody CreateOrderDTO dto){
        return orderService.createOrder(dto);
    }

    @GetMapping("/getOrderById/{id}")
    public Order getOrderById(@PathVariable UUID id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/pay")
    public void pay(@RequestBody OrderIdAndListOfPaymentDTO idAndPayments){
        orderService.payById(idAndPayments.getOrderId(), idAndPayments.getPaymentsDTO());
    }
}