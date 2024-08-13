package com.example.service;

import com.example.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class OrderServiceTest {
    private final OrderService orderService = new OrderService();

    @Test
    void isPaid() {
        // GIVEN
        Order order = Order.builder()
                .sum(new BigDecimal(1000))
                .sumToPay(new BigDecimal(2000))
                .build();

        // WHEN
        boolean paid = orderService.isPaid(order);

        // THEN
        Assertions.assertEquals(false, paid);
    }
}