package com.example.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateOrderDTO {

    /**
     * Крайнее время оплаты
     */
    private LocalDate deadLineOfOrder;

    /**
     * Сумма заказа
     */
    private BigDecimal sumToPay;

    /**
     * Тип клиента
     */
    private ClientType clientType;
}
