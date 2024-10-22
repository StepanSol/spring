package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class PaymentDTO{
    private UUID id;

    /**
     * Время создания оплаты
     */
    private LocalDateTime creationTime;

    /**
     * сумма оплаты
     */
    private BigDecimal sum;
}
