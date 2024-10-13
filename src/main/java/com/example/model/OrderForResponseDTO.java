package com.example.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class OrderForResponseDTO {
    private UUID id;

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
     * Оплачен ли заказ
     */
    private boolean isPaid;

    /**
     * Тип клиента
     */
    private ClientType clientType;

    /**
     * Зачисленные оплаты
     */
    private List<PaymentDTO> payments;
}
