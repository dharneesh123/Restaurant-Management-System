package com.rest.service;

import com.rest.models.MenuItem;
import com.rest.repository.MenuItemRepository;
import java.util.List;

public class MenuItemService {

    private final MenuItemRepository repository;

    public MenuItemService() {
        this.repository = new MenuItemRepository();
    }

    public List<MenuItem> getAllMenuItems() {
        return repository.findAll();
    }

    public void createMenuItem(MenuItem menuItem) {
        repository.save(menuItem);
    }
}
