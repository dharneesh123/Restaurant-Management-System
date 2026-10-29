package com.rest.payment;

public class cardpayment implements paymentmethod{

    

    public void pay(double amount){
        System.out.printf(
            "Card payment of %.2f processed successfully.", amount);
    }
    public String getmethodName(){
        return "card";
    }

    
}