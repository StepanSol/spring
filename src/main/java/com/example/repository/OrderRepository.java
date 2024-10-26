package com.example.repository;

import com.example.model.ClientType;
import com.example.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query(value = "select * from t_order where dead_line_of_order >= now()::date order by create_time",
            nativeQuery = true)
      List<Order> getActualOrders();

    List<Order> findByClientType(ClientType clientType);
}