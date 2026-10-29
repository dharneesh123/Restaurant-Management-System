package com.rest.models;

public class payment {


    private int id;
    private double amount;
    private String method;
    private String status;
   
    

    public payment(int id, double amount, String method, String status) {
        this.id = id;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }
    public int getId() {
        return id;
    }

    public double getamount(){
        return amount;
    }
    public String getmethod(){
        return method;
    }
    public String getstatus(){
        return status;
    }
    @Override
    public String toString(){
        return "Payment ID: " + id 
            + ", Amount: Rs. " + String.format("%.2f", amount)
            + ", Method: " + method
             + ", Status: " + status;
    }

}