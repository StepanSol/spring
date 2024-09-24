package com.example.service;

import com.example.model.CreateOrderDTO;
import com.example.model.Order;
import com.example.model.OrderAndPaymentDTO;
import com.example.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    /**
     * Название компанни, принявшей заказ
     */
    @Value("${nameOfCompany}")
    private String companyName;

    /**
     * Метод сравнивает Сумму, необходимую для оплаты заказа с уже оплаченной суммой
     * @param order
     * @return true, если заказ оплачен
     */
    //Переписал с compareTo
    public boolean isPaid(Order order) {
        return order.getSum().compareTo(order.getSumToPay())>=0;
    }

    /**
     * Метод принимает заказ и List оплат, зачисляет оплаты по очереди на счет заказа.
     * При зачислении суммы, превышающей сумму заказа, остаток зачисляется в поле change(Сдача).
     * Если заказ оплачен предыдущими оплатами, текущая оплата на счёт не зачисляется.
     * @param order
     * @param payments
     * @return заказ с зачисленными оплатами и сдачей.
     */
    public Order pay(Order order, List<Payment> payments) {
        for (int i = 0; i <= payments.size()-1; i++) {
            Payment payment = payments.get(i);
            if (payment.getCreationTime().isAfter(order.getCreateTime()) &
                    payment.getCreationTime().isBefore(order.getDeadLineOfOrder().atTime(23, 59, 59)) &
                    order.getSum().compareTo(order.getSumToPay())<0
            ) {
                order.setSum(order.getSum().add(payment.getSum()));
                order.setNumberOfPayments(order.getNumberOfPayments()+1);
            }
            if (order.getSum().compareTo(order.getSumToPay())>0){
                order.setChange(order.getSum().subtract(order.getSumToPay()));
            }
        }
        return order;
    }

    public Order createOrder(CreateOrderDTO dto) {
        return Order.builder()
                .companyName(companyName)
                .createTime(LocalDateTime.now())
                .deadLineOfOrder(dto.getDeadLineOfOrder())
                .sumToPay(dto.getSumToPay())
                .clientType(dto.getClientType())
                .build();
    }
}