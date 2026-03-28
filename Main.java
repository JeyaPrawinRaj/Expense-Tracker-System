package ExpenseTracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseService expenseService = new ExpenseService();

        int choice;

        do {
            System.out.println("===== EXPENSE TRACKER SYSTEM =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Please enter a number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addExpense(sc, expenseService);
                    break;

                case 2:
                    expenseService.viewAllExpenses();
                    break;

                case 3:
                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }

        } while (choice != 3);

        sc.close();
    }

    public static void addExpense(Scanner sc, ExpenseService expenseService) {
        System.out.println("\n===== ADD EXPENSE =====");

        int id;
        while (true) {
            System.out.print("Enter Expense ID: ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();
                break;
            } else {
                System.out.println("Invalid ID! Please enter a valid number.");
                sc.next();
            }
        }

        String date;
        do {
            System.out.print("Enter Date (dd-mm-yyyy): ");
            date = sc.nextLine().trim();
            if (date.isEmpty()) {
                System.out.println("Date cannot be empty!");
            }
        } while (date.isEmpty());

        double amount;
        while (true) {
            System.out.print("Enter Amount: ");
            if (sc.hasNextDouble()) {
                amount = sc.nextDouble();
                sc.nextLine();
                if (amount > 0) {
                    break;
                } else {
                    System.out.println("Amount must be greater than 0!");
                }
            } else {
                System.out.println("Invalid amount! Please enter a valid number.");
                sc.next();
            }
        }

        String category;
        do {
            System.out.print("Enter Category: ");
            category = sc.nextLine().trim();
            if (category.isEmpty()) {
                System.out.println("Category cannot be empty!");
            }
        } while (category.isEmpty());

        String description;
        do {
            System.out.print("Enter Description: ");
            description = sc.nextLine().trim();
            if (description.isEmpty()) {
                System.out.println("Description cannot be empty!");
            }
        } while (description.isEmpty());

        Expense expense = new Expense(id, date, amount, category, description);
        expenseService.addExpense(expense);
    }
}