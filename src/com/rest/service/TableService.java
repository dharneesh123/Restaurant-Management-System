package com.rest.service;

import com.rest.models.Table;
import com.rest.repository.TableRepository;
import java.util.List;

public class TableService {

    private final TableRepository repository;

    public TableService() {
        this.repository = new TableRepository();
    }

    public List<Table> getAllTables() {
        return repository.findAll();
    }
}