package com.rest.repository;

import com.rest.models.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepository {

    private final List<MenuItem> menuItems = new ArrayList<>();

    public List<MenuItem> findAll() {
        return new ArrayList<>(menuItems);
    }

    public void save(MenuItem menuItem) {
        if (menuItem == null) {
            throw new IllegalArgumentException("Menu item cannot be null.");
        }
        menuItems.add(menuItem);
    }
}
