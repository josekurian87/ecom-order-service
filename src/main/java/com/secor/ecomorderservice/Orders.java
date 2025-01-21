package com.secor.ecomorderservice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long productId;
    private Integer quantity;
    private Long customerId;
    private LocalDateTime orderDate;
    private String status;
    private BigDecimal totalAmount;

    // Getters and Setters
}
