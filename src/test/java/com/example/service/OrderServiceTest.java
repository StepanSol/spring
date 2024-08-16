package com.example.service;

import com.example.model.Order;
import com.example.model.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class OrderServiceTest {
    private final OrderService orderService = new OrderService();
    private static Order order;

    @BeforeAll
    static void createOrder(){
                OrderServiceTest.order = Order.builder()
                .createTime(LocalDateTime.of(2024, 8, 15, 9, 30, 0))
                .deadLineOfOrder(LocalDateTime.of(2024, 8, 15, 23, 59,59))
                .sum(new BigDecimal(0))
                .sumToPay(new BigDecimal(1000))
                .change(new BigDecimal(0))
                .numberOfPayments(0)
                .build();
    }

    @Test
    void isPaid() {
        // GIVEN

        // WHEN
        boolean paid = orderService.isPaid(order);

        // THEN
        Assertions.assertFalse(paid);
    }
    

    @Test
    void pay() {
        // GIVEN
        Payment payment1= Payment.builder()
                .creationTime(LocalDateTime.of(2024, 8, 15, 11, 22))
                .sum(new BigDecimal(500))
                .build();

        Payment payment2= Payment.builder()
                .creationTime(LocalDateTime.of(2024, 8, 15, 11, 23))
                .sum(new BigDecimal(700))
                .build();

            // Оплата 3 не проходит, т.к. счёт оплачен первыми двумя. checkNumberOfPayments показывает 2
            // Сдача так же начисляется только с первых двух оплат (checkChangeSum)
        Payment payment3= Payment.builder()
                .creationTime(LocalDateTime.of(2024, 8, 15, 11, 25))
                .sum(new BigDecimal(700))
                .build();

        List<Payment> payments = new ArrayList<Payment>(List.of(payment1, payment2, payment3));

        // WHEN
        Order testOrder = orderService.pay(order, payments);
        boolean paid =  orderService.isPaid(testOrder);

        // THEN
        Assertions.assertTrue(paid);
    }

    @Test
    void checkNumberOfPayments(){
        pay();
        int expected = 2;
        int actual = order.getNumberOfPayments();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkChangeSum(){
        pay();
        BigDecimal expected = new BigDecimal(200);
        BigDecimal actual = order.getChange();
        Assertions.assertEquals(expected, actual);
    }
}