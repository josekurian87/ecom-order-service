package com.secor.ecomorderservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final Logger LOG = LoggerFactory.getLogger(OrdersController.class);

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @GetMapping
    public List<Orders> getAllOrders() {
        LOG.info("getAllOrders");
        return ordersRepository.findAll();
    }

    @GetMapping("/{orderId}")
    public Orders getOrderForOrderId(@PathVariable Long orderId) {
        LOG.info("getOrderForOrderId for orderID {}", orderId);
        return ordersRepository.findByOrderId(orderId);
    }

    @PostMapping
    public Orders addOrder(@RequestBody Orders order) {
        LOG.info("addOrder for orderID {}", order.getOrderId());
        return ordersRepository.save(order);
    }

    @PutMapping("/{id}")
    public Orders updateOrder(@PathVariable Long id, @RequestBody Orders orderDetails) {
        LOG.info("updateOrder for orderID {}", id);
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
        LOG.info("deleteOrder for orderID {}", id);
        ordersRepository.deleteById(id);
    }
}

