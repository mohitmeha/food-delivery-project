package com.telusko.food_delivery.service;

import com.telusko.food_delivery.model.Order;
import com.telusko.food_delivery.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repo;
    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Order placeOrder(Order order) {
        order.setStatus("RECEIVED");
        return repo.save(order);
    }

    public List<Order> getAll() {
        return repo.findAll();
    }
}
