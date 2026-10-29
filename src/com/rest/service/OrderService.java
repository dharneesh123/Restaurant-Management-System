package com.rest.service;

import com.rest.models.Order;
import com.rest.repository.OrderRepository;
import java.util.List;

public class OrderService {

    private final OrderRepository repository;

    public OrderService() {
        this.repository = new OrderRepository();
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public void createOrder(Order order) {
        repository.save(order);
    }
}