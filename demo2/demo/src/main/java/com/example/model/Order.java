package com.example.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Заказ
 */
@Data
@Builder
public class Order {
    /**
     * Время создания заказа
     */
    private LocalDateTime createTime;

    /**
     * Крайнее время оплаты
     */
    private LocalDate deadLineOfOrder;

    /**
     * Зачисленная сумма
     */
    private BigDecimal sum;

    /**
     * Сумма заказа
     */
    private BigDecimal sumToPay;
}
