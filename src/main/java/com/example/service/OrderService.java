package com.example.service;

import com.example.model.Order;
import com.example.model.Payment;

import java.util.List;

public class OrderService {

    /**
     * Метод сравнивает Сумму, необходимую для оплаты заказа с уже оплаченной суммой
     * @param order
     * @return true, если заказ оплачен
     */
    //Переписал с compareTo
    public boolean isPaid(Order order) {
        return order.getSum().compareTo(order.getSumToPay())>=0;
//        return Objects.equals(order.getSum(), order.getSumToPay());
    }

    /**
     * Метод принимает заказ и List оплат, зачисляет оплаты по очереди на счет заказа.
     * При зачислении суммы, превышающей сумму заказа, остаток зачисляется в поле change(Сдача).
     * Если заказ оплачен предыдущими оплатами, текущая оплата на счёт не зачисляется.
     * @param order
     * @param payments
     * @return заказ с зачисленными оплатами и сдачей.
     */
    //Заменил LocalDate на LocalDateTime в переменной "deadLineOfOrder" класса Order.
    public Order pay(Order order, List<Payment> payments) {
        for (int i = 0; i <= payments.size()-1; i++) {
            Payment payment = payments.get(i);
            if (payment.getCreationTime().isAfter(order.getCreateTime()) &
                    payment.getCreationTime().isBefore(order.getDeadLineOfOrder()) &
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

    //TODO
    // 3. Тесты на OrderService  (https://www.baeldung.com/parameterized-tests-junit-5)
    // 4. Паттерн Builder


}
