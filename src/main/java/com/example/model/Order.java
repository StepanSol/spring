package com.example.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

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
     * Название компанни, обрабатывающей заказ
     */
    private String companyName;

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

    /**
     * Сдача
     */
    private BigDecimal change;

    /**
     * Количество зачисленных оплат
     */
    private int numberOfPayments;

    /**
     * Тип клиента
     */
    private ClientType clientType;
}
