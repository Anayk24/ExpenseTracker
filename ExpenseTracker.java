import java.io.*;
import java.util.*;

public class ExpenseTracker {
    // File name where expenses will be saved using serialization
    private static final String FILE_NAME = "expenses.ser";

    // List to store all Expense objects
    private static List<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Load previously saved expenses from file (if any)
        loadExpenses();

        // Menu loop - keeps running until user chooses Exit
        while (true) {
            System.out.println("\nExpense Tracker Created By Anay Khandelwal");
            System.out.println("1.Add Expense");
            System.out.println("2.View Expenses");
            System.out.println("3.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Take user input for new expense
                    System.out.print("Enter category:");
                    String category = sc.nextLine();
                    System.out.print("Enter amount:");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter date(dd-mm-yyyy):");
                    String date = sc.nextLine();

                    // Create new Expense object and add to list
                    Expense exp = new Expense(category, amount, date);
                    expenses.add(exp);

                    // Save updated list to file
                    saveExpenses();
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    // Display all saved expenses
                    System.out.println("\nYour Expenses");
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded yet.");
                    } else {
                        for (Expense e : expenses) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    // Exit program
                    System.out.println("Exiting... Thank you for using Expense Tracker!");
                    return;

                default:
                    // Handle invalid menu choice
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    // Method to save expenses list into a file using serialization
    private static void saveExpenses() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(expenses);
        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    // Method to load expenses list from file (if file exists)
    private static void loadExpenses() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            expenses = (List<Expense>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // If file not found or error occurs, start with empty list
            expenses = new ArrayList<>();
        }
    }
}
