package com.rest.CLI;

import com.rest.models.payment;
import com.rest.payment.UPIpayment;
import com.rest.payment.cardpayment;
import com.rest.payment.cashpayment;
import com.rest.payment.paymentmethod;
import com.rest.service.paymentservice;
import java.util.Scanner;

public class paymentCLI {
    private final paymentservice service;
    private final Scanner scanner;

    public paymentCLI(paymentservice service) {
        this(service, new Scanner(System.in));
    }

    public paymentCLI(paymentservice service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        int choice = -1;

        while (choice != 0) {
            if (!scanner.hasNextLine()) {
                return;
            }

            System.out.println("\n=== RESTAURANT PAYMENT SYSTEM ===");
            System.out.println("1. Make Payment");
            System.out.println("2. View All Payments");
            System.out.println("3. Find Payment by ID");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        makepayment();
                        break;
                    case 2:
                        viewAllpayments();
                        break;
                    case 3:
                        findpaymentById();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Enter a valid number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void findpaymentById() {
        System.out.print("Enter payment ID: ");
        if (!scanner.hasNextLine()) {
            return;
        }
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            payment foundPayment = service.getpaymentId(id);
            if (foundPayment == null) {
                System.out.println("Payment not found.");
            } else {
                System.out.println(foundPayment);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid payment ID.");
        }
    }

    private void viewAllpayments() {
        for (payment currentPayment : service.getAllpayments()) {
            System.out.println(currentPayment);
        }
    }

    private void makepayment() {
        System.out.println("1. Cash");
        System.out.println("2. UPI");
        System.out.println("3. card");
        System.out.print("Choose payment method: ");

        if (!scanner.hasNextLine()) {
            return;
        }
        paymentmethod method;
        String methodChoice = scanner.nextLine().trim();
        if ("1".equals(methodChoice)) {
            method = new cashpayment();
        } else if ("2".equals(methodChoice)) {
            method = new UPIpayment();
        } else if ("3".equals(methodChoice)) {
            method = new cardpayment();
        } else {
            System.out.println("Invalid payment method.");
            return;
        }

        System.out.print("Enter amount: ");
        if (!scanner.hasNextLine()) {
            return;
        }
        try {
            double amount = Double.parseDouble(scanner.nextLine().trim());
            if (!Double.isFinite(amount) || amount <= 0) {
                System.out.println("Amount must be a positive number.");
                return;
            }
            System.out.println(service.processpayment(method, amount));
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount.");
        }
    }
}
