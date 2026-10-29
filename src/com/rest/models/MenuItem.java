package com.rest.models;

public class MenuItem {

    private final int menuItemId;
    private final String name;
    private final double price;

    public MenuItem(int menuItemId, String name, double price) {
        if (menuItemId <= 0) {
            throw new IllegalArgumentException("Menu item ID must be greater than zero.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Menu item name cannot be empty.");
        }
        if (!Double.isFinite(price) || price <= 0) {
            throw new IllegalArgumentException("Price must be finite and greater than zero.");
        }

        this.menuItemId = menuItemId;
        this.name = name.trim();
        this.price = price;
    }

    public int getMenuItemId() {
        return menuItemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MenuItem{menuItemId=" + menuItemId
                + ", name='" + name + '\''
                + ", price=" + price + "}";
    }
}