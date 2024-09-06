package com.example.service;

import com.example.model.Order;
import com.example.model.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class OrderServiceTest {
    private final OrderService orderService = new OrderService();
    private static Order order;  // Необходимо ли это поле?

    static Order createOrder(){
                OrderServiceTest.order = Order.builder()
                .createTime(LocalDateTime.of(2024, 8, 15, 9, 30, 0))
                .deadLineOfOrder(LocalDate.of(2024, 8, 15))
                .sum(new BigDecimal(0))
                .sumToPay(new BigDecimal(1000))
                .change(new BigDecimal(0))
                .numberOfPayments(0)
                .build();
                return order;
    }

    static Payment createPayment(LocalDateTime creationTime, BigDecimal sum){
        return Payment.builder()
                .creationTime(creationTime)
                .sum(sum)
                .build();
    }

     static Stream<Arguments> provideOrderAndPayments() {
        Order order = createOrder();
        Order order2 = createOrder();
        Payment payment1 = createPayment(LocalDateTime.of(2024, 8, 15, 11, 22), new BigDecimal(500));
        Payment payment2 = createPayment(LocalDateTime.of(2024, 8, 15, 11, 24), new BigDecimal(700));
        Payment payment3 = createPayment(LocalDateTime.of(2024, 8, 15, 11, 26), new BigDecimal(700));
        List<Payment> payments = new ArrayList<>(List.of(payment1,payment2,payment3));
        List<Payment> payments2 = new ArrayList<>(List.of(payment2,payment3));

        return Stream.of(
                Arguments.of(order,payments, new BigDecimal(200)),
                Arguments.of(order2,payments2, new BigDecimal(400))
        );
    }

    @Test
    void isPaid() {
        Assertions.assertFalse(orderService.isPaid(createOrder()));
    }

    @ParameterizedTest
    @MethodSource("provideOrderAndPayments")
    void parameterizedPay(Order order, List<Payment> payments){
        Order testOrder = orderService.pay(order, payments);
        Assertions.assertTrue(orderService.isPaid(testOrder));
    }

    @ParameterizedTest
    @MethodSource("provideOrderAndPayments")
    void checkNumberOfPayments(Order order, List<Payment> payments){
        Order testOrder = orderService.pay(order, payments);
        Assertions.assertEquals(2, testOrder.getNumberOfPayments());
    }

    @ParameterizedTest
    @MethodSource("provideOrderAndPayments")
    void checkChangeSum(Order order, List<Payment> payments, BigDecimal expected){
        Order testOrder = orderService.pay(order, payments);
        Assertions.assertEquals(expected, testOrder.getChange());
    }
}