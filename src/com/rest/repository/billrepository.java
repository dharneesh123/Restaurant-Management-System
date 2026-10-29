package com.rest.repository;

import com.rest.models.bill;
import java.util.ArrayList;
import java.util.List;

public class billrepository {

    private final List<bill> bills = new ArrayList<>();

    public void save(bill newBill) {
        if (newBill == null) {
            throw new IllegalArgumentException("Bill cannot be null.");
        }
        bills.add(newBill);
    }

    public List<bill> findAll() {
        return new ArrayList<>(bills);
    }

    public bill findById(int id) {
        for (bill currentBill : bills) {
            if (currentBill.getBillId() == id) {
                return currentBill;
            }
        }
        return null;
    }
}