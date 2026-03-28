package ExpenseTracker;

import java.util.ArrayList;

public class ExpenseService {
    private ArrayList<Expense> expenseList = new ArrayList<>();

    // Add Expense
    public void addExpense(Expense expense) {
        expenseList.add(expense);
        System.out.println("Expense added successfully!\n");
    }

    // View All Expenses
    public void viewAllExpenses() {
        if (expenseList.isEmpty()) {
            System.out.println("No expenses found.\n");
            return;
        }

        System.out.println("\n===== ALL EXPENSES =====");
        System.out.printf("%-5s %-15s %-10s %-15s %-20s%n",
                "ID", "Date", "Amount", "Category", "Description");
        System.out.println("---------------------------------------------------------------");

        for (Expense expense : expenseList) {
            System.out.println(expense);
        }
        System.out.println();
    }
}