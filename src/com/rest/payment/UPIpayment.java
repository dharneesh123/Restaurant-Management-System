package com.rest.payment;

public class UPIpayment implements paymentmethod {
    @Override
    public void pay(double amount) {
        System.out.printf("UPI payment of %.2f processed successfully.%n", amount);
    }

    @Override
    public String getmethodName() {
        return "UPI";
    }
}