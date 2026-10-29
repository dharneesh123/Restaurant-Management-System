package com.rest.CLI;

import com.rest.models.Order;
import com.rest.service.OrderService;
import java.util.List;
import java.util.Scanner;

public class OrderCLI {

    private final OrderService service;
    private final Scanner scanner;

    public OrderCLI(OrderService service) {
        this(service, new Scanner(System.in));
    }

    public OrderCLI(OrderService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("=== RESTAURANT ORDER MANAGEMENT ===");
        System.out.println("1. Create Order");
        System.out.println("2. View All Orders");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");

        if (!scanner.hasNextLine()) {
            return;
        }

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("Invalid choice. Please enter a number.");
            return;
        }

        if (choice == 1) {
            createOrder();
        } else if (choice == 2) {
            List<Order> orders = service.getAllOrders();
            System.out.println("\n=== ALL ORDERS ===");
            if (orders.isEmpty()) {
                System.out.println("No orders found.");
            } else {
                for (Order order : orders) {
                    System.out.println(order);
                }
            }
        } else if (choice == 0) {
            System.out.println("Thank you!");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void createOrder() {
        try {
            System.out.print("Enter order ID: ");
            if (!scanner.hasNextLine()) {
                return;
            }
            int orderId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter quantity: ");
            if (!scanner.hasNextLine()) {
                return;
            }
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter price: ");
            if (!scanner.hasNextLine()) {
                return;
            }
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter table ID: ");
            if (!scanner.hasNextLine()) {
                return;
            }
            int tableId = Integer.parseInt(scanner.nextLine());

            Order order = new Order(orderId, quantity, price, tableId);
            service.createOrder(order);
            System.out.println("Order created: " + order);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid input. Please enter valid numbers.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Could not create order: " + exception.getMessage());
        }
    }
}