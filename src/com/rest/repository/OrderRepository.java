package com.rest.repository;

import com.rest.models.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    public void save(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        orders.add(order);
    }
}