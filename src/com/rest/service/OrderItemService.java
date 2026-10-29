package com.rest.service;

import com.rest.models.OrderItem;
import com.rest.repository.OrderItemRepository;
import java.util.List;

public class OrderItemService {

    private final OrderItemRepository repository;

    public OrderItemService() {
        this.repository = new OrderItemRepository();
    }

    public List<OrderItem> getAllOrderItems() {
        return repository.findAll();
    }

    public void createOrderItem(OrderItem orderItem) {
        repository.save(orderItem);
    }
}