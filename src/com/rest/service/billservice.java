package com.rest.service;

import com.rest.models.OrderItem;
import com.rest.models.bill;
import com.rest.repository.billrepository;
import java.util.List;

public class billservice {

    private final billrepository repository;
    private int nextBillId = 1;

    public billservice() {
        this.repository = new billrepository();
    }

    public bill createBill(int orderId, List<OrderItem> items) {
        bill newBill = new bill(nextBillId, orderId, items);
        repository.save(newBill);
        nextBillId++;
        return newBill;
    }

    public List<bill> getAllBills() {
        return repository.findAll();
    }

    public bill getBillById(int id) {
        return repository.findById(id);
    }
}