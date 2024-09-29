package com.example.service;

import com.example.model.CreateOrderDTO;
import com.example.model.Order;
import com.example.model.Payment;
import com.example.model.PaymentDTO;
import com.example.repository.OrderRepository;
import com.example.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

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

    @Transactional
    public void payById(UUID orderId, List<PaymentDTO> paymentsDTO){
        Optional<Order> orderOptional = Optional.ofNullable(orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException(String.valueOf(orderId))));
        Order order = orderOptional.get();
        for (PaymentDTO paymentDTO:paymentsDTO) {
            Payment payment = Payment.builder()
                    .creationTime(paymentDTO.getCreationTime())
                    .sum(paymentDTO.getSum())
                    .order(order)
                    .build();
            if (payment.getCreationTime().isAfter(order.getCreateTime())&&
                    payment.getCreationTime().isBefore(order.getDeadLineOfOrder().atTime(23,59,59))&&
                    order.getSum().compareTo(order.getSumToPay())<0
            ){
                order.setSum(order.getSum().add(payment.getSum()));
                order.setNumberOfPayments(order.getNumberOfPayments()+1);
                paymentRepository.save(payment);
            }
            if (order.getSum().compareTo(order.getSumToPay())>0){
                order.setChange(order.getSum().subtract(order.getSumToPay()));
            }
        }
        orderRepository.save(order);
    }


    @Transactional
    public Order createOrder(CreateOrderDTO dto) {
        Order order = Order.builder()
                .companyName(companyName)
                .createTime(LocalDateTime.now())
                .deadLineOfOrder(dto.getDeadLineOfOrder())
                .sum(BigDecimal.ZERO)
                .sumToPay(dto.getSumToPay())
                .change(BigDecimal.ZERO)
                .clientType(dto.getClientType())
                .build();
        return orderRepository.save(order);
    }

    public Order getOrderById (UUID id){
        return orderRepository.findById(id).get();
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}