package com.example.Shipment.Order.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Shipment.Order.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findByEmail(String email);
}
