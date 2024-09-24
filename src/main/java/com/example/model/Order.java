package com.example.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Заказ
 */
@Data
@Builder
@Entity
@Table(name="t_order")
public class Order {

    @Id
    @GeneratedValue
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
     * Тип клиента
     */
    @Enumerated(value = EnumType.STRING)
    private ClientType clientType;
}