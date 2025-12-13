package com.telusko.food_delivery.controller;

import com.telusko.food_delivery.model.Order;
import com.telusko.food_delivery.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) { this.service = service; }

    @PostMapping
    public Order place(@RequestBody Order order) {
        if (order == null || order.getItems() == null) {
            throw new IllegalArgumentException("Order or order.items cannot be null");
        }
        double total = order.getItems().stream()
                .mapToDouble(i -> i.getPrice() * i.getQty())
                .sum();
        order.setTotal(total);
        return service.placeOrder(order);
    }

    @GetMapping
    public List<Order> all() {
        return service.getAll();
    }
}
