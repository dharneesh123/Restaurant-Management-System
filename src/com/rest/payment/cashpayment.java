package com.rest.payment;

public class cashpayment implements paymentmethod{

    @Override
    public void pay(double amount){
        System.out.printf("Cash payment of %.2f processed successfully.%n", amount);
    }
    @Override
    public String getmethodName(){
        return "Cash ";
    }
}