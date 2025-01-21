package com.secor.ecomorderservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Orders findByOrderId(Long orderId);
}
