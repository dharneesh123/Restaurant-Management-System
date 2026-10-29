package com.rest;

import com.rest.CLI.OrderCLI;
import com.rest.CLI.TableCLI;
import com.rest.CLI.billCLI;
import com.rest.CLI.menuItemCLI;
import com.rest.CLI.paymentCLI;
import com.rest.service.MenuItemService;
import com.rest.service.OrderService;
import com.rest.service.TableService;
import com.rest.service.billservice;
import com.rest.service.paymentservice;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TableService tableService = new TableService();
        OrderService orderService = new OrderService();
        MenuItemService menuItemService = new MenuItemService();
        paymentservice paymentService = new paymentservice();
        billservice billService = new billservice();

        while (true) {
            System.out.println("\n=== RESTAURANT MANAGEMENT SYSTEM ===");
            System.out.println("1. Table Management");
            System.out.println("2. Order Management");
            System.out.println("3. Menu Item Management");
            System.out.println("4. Payment Management");
            System.out.println("5. Bill Management");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextLine()) {
                break;
            }

            String choice = scanner.nextLine().trim();
            if ("1".equals(choice)) {
                new TableCLI(tableService, scanner).start();
            } else if ("2".equals(choice)) {
                new OrderCLI(orderService, scanner).start();
            } else if ("3".equals(choice)) {
                new menuItemCLI(menuItemService, scanner).start();
            } else if ("4".equals(choice)) {
                new paymentCLI(paymentService, scanner).start();
            } else if ("5".equals(choice)) {
                new billCLI(billService, scanner).start();
            } else if ("0".equals(choice)) {
                System.out.println("Thank you!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}