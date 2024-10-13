package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Заказ
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    /**
     * Зачисленные оплаты
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Payment> payments;

    public void pay(Payment payment){
        sum = sum.add(payment.getSum());
        numberOfPayments++;
        payment.setOrder(this);
        payments.add(payment);
    }

    /**
     * Метод сравнивает Сумму, необходимую для оплаты заказа с уже оплаченной суммой
     * @return true, если заказ оплачен
     */
    public boolean isPaid() {
        return sum.compareTo(sumToPay)>=0;
    }

    public void payChange(){
        change = sum.subtract(sumToPay);
    }
}