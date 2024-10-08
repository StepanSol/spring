package com.example.model;


import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class PaymentDTO{
    /**
     * Время создания оплаты
     */
    private LocalDateTime creationTime;

    /**
     * сумма оплаты
     */
    private BigDecimal sum;
}
