package ExpenseTracker;

public class Expense {
    private int id;
    private String date;
    private double amount;
    private String category;
    private String description;

    public Expense(int id, String date, double amount, String category, String description) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-10.2f %-15s %-20s",
                id, date, amount, category, description);
    }
}