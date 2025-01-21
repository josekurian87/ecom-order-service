package com.secor.ecomorderservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @GetMapping("/{orderId}")
    public Orders getOrderForOrderId(@PathVariable Long orderId) {
        return ordersRepository.findByOrderId(orderId);
    }

    @PostMapping
    public Orders addOrder(@RequestBody Orders order) {
        return ordersRepository.save(order);
    }

    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders orderDetails) {
        Orders order = ordersRepository.findById(id).orElseThrow();
        order.setProductId(orderDetails.getProductId());
        order.setCustomerId(orderDetails.getCustomerId());
        order.setOrderDate(orderDetails.getOrderDate());
        order.setStatus(orderDetails.getStatus());
        order.setTotalAmount(orderDetails.getTotalAmount());
        return ordersRepository.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        ordersRepository.deleteById(id);
    }
}

