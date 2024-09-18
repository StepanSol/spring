package com.example.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderAndPaymentDTO {
    private Order order;
    private List<Payment> payments;
}