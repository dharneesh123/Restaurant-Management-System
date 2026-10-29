
package com.rest.models;

public class OrderItem {
    private final String itemName;
    private final int quantity;
    private final double price;

    public OrderItem(String itemName, int quantity, double price) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (!Double.isFinite(price) || price <= 0) {
            throw new IllegalArgumentException("Price must be finite and greater than zero.");
        }

        this.itemName = itemName.trim();
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return "OrderItem{itemName='" + itemName + "', quantity=" + quantity
                + ", price=" + price + "}";
    }
}