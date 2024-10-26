package com.example.repository;

import com.example.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    @Query(value = "SELECT * FROM payment WHERE sum = (SELECT MAX(sum) FROM payment)", nativeQuery = true)
    List<Payment> getMaxSumPayment();
}
