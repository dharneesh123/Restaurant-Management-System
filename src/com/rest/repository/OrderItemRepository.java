package com.rest.repository;

import com.rest.models.OrderItem;
import java.util.ArrayList;
import java.util.List;

public class OrderItemRepository {

    private final List<OrderItem> orderItems = new ArrayList<>();

    public List<OrderItem> findAll() {
        return new ArrayList<>(orderItems);
    }

    public void save(OrderItem orderItem) {
        if (orderItem == null) {
            throw new IllegalArgumentException("Order item cannot be null.");
        }
        orderItems.add(orderItem);
    }
}