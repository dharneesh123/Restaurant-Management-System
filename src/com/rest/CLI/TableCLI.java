package com.rest.CLI;

import com.rest.models.Table;
import com.rest.service.TableService;
import java.util.List;
import java.util.Scanner;

public class TableCLI {

    private final TableService service;
    private final Scanner scanner;

    public TableCLI(TableService service) {
        this(service, new Scanner(System.in));
    }

    public TableCLI(TableService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("=== RESTAURANT TABLE MANAGEMENT ===");
        System.out.println("1. View All Tables");
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
            List<Table> tables = service.getAllTables();
            System.out.println("\n=== ALL TABLES ===");
            for (Table table : tables) {
                System.out.println(table);
            }
        } else if (choice == 0) {
            System.out.println("Thank you!");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}