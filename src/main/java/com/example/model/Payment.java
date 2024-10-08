package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


/**
 * Оплата
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue
    private UUID id;

    /**
     * Время создания оплаты
     */
    private LocalDateTime creationTime;

    /**
     * сумма оплаты
     */
    private BigDecimal sum;

    /**
     * Оплачиваемый заказ
     */
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
