package com.example.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Оплата
 */
@Data
@Builder
public class Payment {
    /**
     * Время создания оплаты
     */
    private LocalDateTime creationTime;

    /**
     * сумма оплаты
     */
    private BigDecimal sum;
}
