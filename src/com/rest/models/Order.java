package com.rest.models;

public class Order {

    private final int orderId;
    private final int quantity;
    private final double price;
    private final int tableId;

    public Order(int orderId, int quantity, double price, int tableId) {
        if (orderId <= 0) {
            throw new IllegalArgumentException("Order ID must be greater than zero.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (!Double.isFinite(price) || price <= 0) {
            throw new IllegalArgumentException("Price must be finite and greater than zero.");
        }
        if (tableId <= 0) {
            throw new IllegalArgumentException("Table ID must be greater than zero.");
        }

        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
        this.tableId = tableId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getTableId() {
        return tableId;
    }

    @Override
    public String toString() {
        return "Order{orderId=" + orderId + ", quantity=" + quantity
                + ", price=" + price + ", tableId=" + tableId + "}";
    }
}