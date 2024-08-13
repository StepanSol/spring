package com.example.service;

import com.example.model.Order;

import java.util.Objects;
public class OrderService {

    public boolean isPaid(Order order) {
        return Objects.equals(order.getSum(), order.getSumToPay());
    }

    //TODO
    // 1.Метод для зачисления на счёт (Payment -> Order) Принимает Order и лист Payment. Возвращает изменённый Order
    // 1.1 Условие: Дата Payment не должна быть больше, чем deadLineOfOrder, и меньше чем createTime
    // 2. Javadoc
    // 3. Тесты на OrderService  (https://www.baeldung.com/parameterized-tests-junit-5)
    // 4. Паттерн Builder
    // 5. Разобраться с пакетами 



}
