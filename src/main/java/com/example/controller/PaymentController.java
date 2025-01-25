package com.example.controller;

import com.example.model.MaxSumPaymentDTO;
import com.example.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/getMaxSumPaymentQuery")
    public List<MaxSumPaymentDTO> getMaxSumPayment(){
        return paymentService.getMaxSumPayment();
    }

    @GetMapping("/getMaxSumPaymentStreamAPI")
    public List<MaxSumPaymentDTO> getMaxSumPaymentStreamAPI(){
        return paymentService.getMaxSumPaymentStreamAPI();
    }

    @GetMapping("/getMaxSumPaymentCleanJava")
    public List<MaxSumPaymentDTO> getMaxSumPaymentCleanJava() {
        return paymentService.getMaxSumPaymentCleanJava();
    }
}
