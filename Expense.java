import java.io.Serializable;

// Expense class represents a single expense entry
// Implements Serializable so objects can be saved to a file
class Expense implements Serializable {
    // Category of the expense (e.g., Food, Travel, Shopping)
    private String category;

    // Amount spent on the expense
    private double amount;

    // Date of the expense in dd-mm-yyyy format
    private String date;

    // Constructor to initialize an Expense object with category, amount, and date
    public Expense(String category, double amount, String date) {
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    // toString method returns a readable string format of the expense
    @Override
    public String toString() {
        return "Category: " + category + " | Amount: " + amount + " | Date: " + date;
    }
}
