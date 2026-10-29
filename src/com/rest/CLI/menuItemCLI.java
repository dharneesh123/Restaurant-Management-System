package com.rest.CLI;

import com.rest.models.MenuItem;
import com.rest.service.MenuItemService;
import java.util.List;
import java.util.Scanner;

public class menuItemCLI {

    private final MenuItemService service;
    private final Scanner scanner;

    public menuItemCLI(MenuItemService service) {
        this(service, new Scanner(System.in));
    }

    public menuItemCLI(MenuItemService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("=== RESTAURANT MENU ITEM MANAGEMENT ===");
        System.out.println("1. Create Menu Item");
        System.out.println("2. View All Menu Items");
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
            createMenuItem();
        } else if (choice == 2) {
            List<MenuItem> menuItems = service.getAllMenuItems();
            System.out.println("\n=== ALL MENU ITEMS ===");
            if (menuItems.isEmpty()) {
                System.out.println("No menu items found.");
            } else {
                for (MenuItem menuItem : menuItems) {
                    System.out.println(menuItem);
                }
            }
        } else if (choice == 0) {
            System.out.println("Thank you!");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void createMenuItem() {
        try {
            System.out.print("Enter menu item ID: ");
            if (!scanner.hasNextLine()) {
                return;
            }
            int menuItemId = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter menu item name: ");
            if (!scanner.hasNextLine()) {
                return;
            }
            String name = scanner.nextLine();

            System.out.print("Enter price: ");
            if (!scanner.hasNextLine()) {
                return;
            }
            double price = Double.parseDouble(scanner.nextLine());

            MenuItem menuItem = new MenuItem(menuItemId, name, price);
            service.createMenuItem(menuItem);
            System.out.println("Menu item created: " + menuItem);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid input. Please enter valid numbers.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Could not create menu item: " + exception.getMessage());
        }
    }
}