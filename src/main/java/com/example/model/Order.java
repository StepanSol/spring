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
    //Заменил LocalDate на LocalDateTime
    private LocalDateTime deadLineOfOrder;

    /**
     * Зачисленная сумма
     */
    private BigDecimal sum;

    /**
     * Сумма заказа
     */
    private BigDecimal sumToPay;

    /**
     * Сдача
     */
    private BigDecimal change;

    /**
     * Количество зачисленных оплат
     */
    private int numberOfPayments;
}
