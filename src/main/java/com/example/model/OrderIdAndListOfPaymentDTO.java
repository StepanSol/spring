package com.example.model;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class OrderIdAndListOfPaymentDTO {
    private UUID orderId;
    private List<PaymentDTO> paymentsDTO;
}
