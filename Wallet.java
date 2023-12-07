import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Wallet {
    private int balance;
    private List<Transaction> transactions;
    private int savingsGoal;

    public Wallet() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.savingsGoal = 0;
    }

    public void displayBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    public void addFunds() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to add: ");
        int amount = scanner.nextInt();
        balance += amount;
        transactions.add(new Transaction(new Date(), "Added " + amount + " Ar to wallet"));
        System.out.println("Added " + amount + " Ar to wallet");
    }

    public void subtractFunds() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to subtract: ");
        int amount = scanner.nextInt();
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction(new Date(), "Subtracted " + amount + " Ar from wallet"));
            System.out.println("Subtract " + amount + " Ar from wallet");
        } else {
            System.out.println("Insufficient funds. Transaction canceled.");
        }
    }

    public void setSavingsGoal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your savings goal amount: ");
        savingsGoal = scanner.nextInt();
        System.out.println("Savings goal set to " + savingsGoal + " Ar.");
    }

    public void trackSavingsProgress() {
        System.out.println("Current savings progress: " + balance + " / " + savingsGoal + " Ar");
    }

    public void getAllTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDate() + ": " + transaction.getDescription());
        }
    }

    public static void main(String[] args) {
        Wallet wallet = new Wallet();

        System.out.println("Welcome to the wallet program");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1. Display Balance\n" +
                            "2. Add Funds\n" +
                            "3. Subtract Funds\n" +
                            "4. Set Savings Goal\n" +
                            "5. Track Savings Progress\n" +
                            "6. View All Transactions\n" +
                            "7. Quit"
            );
            System.out.print("Choose an option (1-7): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    wallet.displayBalance();
                    break;
                case 2:
                    wallet.addFunds();
                    break;
                case 3:
                    wallet.subtractFunds();
                    break;
                case 4:
                    wallet.setSavingsGoal();
                    break;
                case 5:
                    wallet.trackSavingsProgress();
                    break;
                case 6:
                    wallet.getAllTransactions();
                    break;
                case 7:
                    System.out.println("Exiting wallet program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 7.");
            }
        }
    }
}

class Transaction {
    private Date date;
    private String description;

    public Transaction(Date date, String description) {
        this.date = date;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
