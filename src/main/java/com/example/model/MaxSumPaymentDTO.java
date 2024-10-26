package com.example.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
public class MaxSumPaymentDTO {
    private UUID id;

    /**
     * Время создания оплаты
     */
    private LocalDateTime creationTime;

    /**
     * Сумма оплаты
     */
    private BigDecimal sum;

    private UUID orderID;
}
