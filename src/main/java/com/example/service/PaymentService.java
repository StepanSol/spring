package com.example.service;

import com.example.model.MaxSumPaymentDTO;
import com.example.model.Payment;
import com.example.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public List<MaxSumPaymentDTO> getMaxSumPayment() {
        List<Payment> payments = paymentRepository.getMaxSumPayment();
        List<MaxSumPaymentDTO> maxSumPaymentDTOs= new ArrayList<>();
        for (Payment payment: payments){
            maxSumPaymentDTOs.add(mapPaymentToMaxSumDTO(payment));
        }
        return maxSumPaymentDTOs;
    }

    public List<MaxSumPaymentDTO> getMaxSumPaymentStreamAPI() {
        List<Payment> payments = paymentRepository.findAll();
        BigDecimal maxSum = payments.stream()
                .map(Payment::getSum)
                .max(Comparator.naturalOrder()).get();
        return payments.stream()
                .filter(p -> p.getSum().compareTo(maxSum) == 0)
                .map(this::mapPaymentToMaxSumDTO)
                .toList();
    }

    public List<MaxSumPaymentDTO> getMaxSumPaymentCleanJava() {
        List<Payment> payments = paymentRepository.findAll();
        BigDecimal maxSum = BigDecimal.ZERO;
        for (Payment payment : payments){
            if (payment.getSum().compareTo(maxSum) > 0)
                maxSum = payment.getSum();
        }
        List<MaxSumPaymentDTO> maxSumPaymentDTOs = new ArrayList<>();
        for (Payment payment : payments){
            if (payment.getSum().compareTo(maxSum) == 0)
                maxSumPaymentDTOs.add(mapPaymentToMaxSumDTO(payment));
        }
        return maxSumPaymentDTOs;
    }

    public MaxSumPaymentDTO mapPaymentToMaxSumDTO(Payment payment){
        return MaxSumPaymentDTO.builder()
                .id(payment.getId())
                .creationTime(payment.getCreationTime())
                .sum(payment.getSum())
                .orderID(payment.getOrder().getId())
                .build();
    }
}
