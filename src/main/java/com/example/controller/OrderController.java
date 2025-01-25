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
    public OrderForResponseDTO getOrderById(@PathVariable UUID id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/getAllOrders")
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrdersStream();
    }

    @PostMapping("/pay")
    public void pay(@RequestBody OrderIdAndListOfPaymentDTO idAndPayments){
        orderService.payById(idAndPayments.getOrderId(), idAndPayments.getPaymentsDTO());
    }

    @GetMapping("/getActualOrders")
    public List<OrderDTO> getActualOrders(){
        return orderService.getActualOrders();
    }

    @PostMapping("/getOrdersByClientTypeHQL")
    public List<OrderDTO> getByClientTypeHQL(@RequestBody ClientType clientType){
       return orderService.getByClientTypeHQL(clientType);
    }

    @PostMapping("/getOrdersByClientTypeSQL")
    public List<OrderDTO> getByClientTypeSQL(@RequestBody ClientType clientType){
        return orderService.getByClientTypeSQL(clientType);
    }

    @PostMapping("/getOrdersByClientTypeSpringData")
    public List<OrderDTO> getByClientType(@RequestBody ClientType clientType){
        return orderService.getByClientTypeSpringData(clientType);
    }
}