package com.rest.CLI;

import com.rest.models.OrderItem;
import com.rest.service.OrderItemService;
import java.util.List;
import java.util.Scanner;

public class OrderItemCLI {

    private final OrderItemService service;
    private final Scanner scanner;

    public OrderItemCLI(OrderItemService service) {
        this(service, new Scanner(System.in));
    }

    public OrderItemCLI(OrderItemService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("=== RESTAURANT ORDER ITEM MANAGEMENT ===");
        System.out.println("1. Create Order Item");
        System.out.println("2. View All Order Items");
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
            createOrderItem();
        } else if (choice == 2) {
            List<OrderItem> orderItems = service.getAllOrderItems();
            System.out.println("\n=== ALL ORDER ITEMS ===");

            if (orderItems.isEmpty()) {
                System.out.println("No order items found.");
            } else {
                for (OrderItem orderItem : orderItems) {
                    System.out.println(orderItem);
                }
            }
        } else if (choice == 0) {
            System.out.println("Thank you!");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void createOrderItem() {
        try {
            System.out.print("Enter item name: ");
            if (!scanner.hasNextLine()) {
                return;
            }
            String itemName = scanner.nextLine();

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

            OrderItem orderItem = new OrderItem(itemName, quantity, price);
            service.createOrderItem(orderItem);
            System.out.println("Order item created: " + orderItem);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid input. Please enter valid numbers.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Could not create order item: " + exception.getMessage());
        }
    }
}