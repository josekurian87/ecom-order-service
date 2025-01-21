package com.secor.ecomorderservice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private Long orderId;
    private Long productId;
    private Integer quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "orderId", insertable = false, updatable = false)
    private Orders order;

    // Getters and Setters
}
