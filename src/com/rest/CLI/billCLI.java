package com.rest.CLI;

import com.rest.models.OrderItem;
import com.rest.models.bill;
import com.rest.service.billservice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class billCLI {

    private final billservice service;
    private final Scanner scanner;

    public billCLI(billservice service) {
        this(service, new Scanner(System.in));
    }

    public billCLI(billservice service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n=== RESTAURANT BILL MANAGEMENT ===");
            System.out.println("1. Create Bill");
            System.out.println("2. View All Bills");
            System.out.println("3. Find Bill by ID");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextLine()) {
                return;
            }

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        createBill();
                        break;
                    case 2:
                        viewAllBills();
                        break;
                    case 3:
                        findBillById();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Enter a valid number.");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void createBill() {
        try {
            System.out.print("Enter order ID: ");
            if (!scanner.hasNextLine()) {
                return;
            }
            int orderId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter number of items: ");
            if (!scanner.hasNextLine()) {
                return;
            }
            int itemCount = Integer.parseInt(scanner.nextLine().trim());
            if (itemCount <= 0) {
                System.out.println("Number of items must be greater than zero.");
                return;
            }

            List<OrderItem> items = new ArrayList<>();
            for (int i = 1; i <= itemCount; i++) {
                System.out.println("Item " + i + ":");
                System.out.print("Enter item name: ");
                if (!scanner.hasNextLine()) {
                    return;
                }
                String itemName = scanner.nextLine().trim();

                System.out.print("Enter quantity: ");
                if (!scanner.hasNextLine()) {
                    return;
                }
                int quantity = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Enter unit price: ");
                if (!scanner.hasNextLine()) {
                    return;
                }
                double price = Double.parseDouble(scanner.nextLine().trim());
                items.add(new OrderItem(itemName, quantity, price));
            }

            bill createdBill = service.createBill(orderId, items);
            System.out.println("Bill created: " + createdBill);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid input. Please enter valid numbers.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Could not create bill: " + exception.getMessage());
        }
    }

    private void viewAllBills() {
        List<bill> bills = service.getAllBills();
        if (bills.isEmpty()) {
            System.out.println("No bills found.");
            return;
        }
        for (bill currentBill : bills) {
            System.out.println(currentBill);
        }
    }

    private void findBillById() {
        System.out.print("Enter bill ID: ");
        if (!scanner.hasNextLine()) {
            return;
        }
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            bill foundBill = service.getBillById(id);
            if (foundBill == null) {
                System.out.println("Bill not found.");
            } else {
                System.out.println(foundBill);
            }
        } catch (NumberFormatException exception) {
            System.out.println("Invalid bill ID.");
        }
    }
}