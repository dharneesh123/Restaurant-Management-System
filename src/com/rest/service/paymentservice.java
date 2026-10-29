package com.rest.service;

import com.rest.models.payment;
import com.rest.payment.paymentmethod;
import com.rest.repository.paymentrepository;
import java.util.List;

public class paymentservice {

    private final paymentrepository repository;
    private int nextPaymentId = 1;

    public paymentservice() {
        repository = new paymentrepository();
    }

    public payment processpayment(paymentmethod method, double amount) {
        if (method == null) {
            throw new IllegalArgumentException("Payment method cannot be null.");
        }
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Amount must be finite and greater than zero.");
        }

        method.pay(amount);

        payment processedPayment = new payment(
                nextPaymentId++, amount, method.getmethodName(), "SUCCESS");
        repository.save(processedPayment);
        return processedPayment;
    }

    public List<payment> getAllpayments() {
        return repository.findAll();
    }

    public payment getpaymentId(int id) {
        return repository.findById(id);
    }
}