package com.rest.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bill {

    private final int billId;
    private final int orderId;
    private final List<OrderItem> items;
    private final double totalAmount;

    public bill(int billId, int orderId, List<OrderItem> items) {
        if (billId <= 0) {
            throw new IllegalArgumentException("Bill ID must be greater than zero.");
        }
        if (orderId <= 0) {
            throw new IllegalArgumentException("Order ID must be greater than zero.");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Bill must contain at least one item.");
        }

        this.billId = billId;
        this.orderId = orderId;
        this.items = Collections.unmodifiableList(new ArrayList<>(items));
        this.totalAmount = this.items.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }

    public int getBillId() {
        return billId;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Bill ID: " + billId
                + ", Order ID: " + orderId
                + ", Items: " + items
                + ", Total: Rs. " + String.format("%.2f", totalAmount);
    }
}