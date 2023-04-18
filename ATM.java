import java.util.Scanner;

public class ATM {
    private int balance;
    private int transactions;

    public ATM() {
        this.balance = 0;
        this.transactions = 0;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM.");
        System.out.print("Enter your user ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter your user PIN: ");
        String userPin = scanner.nextLine();

        if (validateUser(userId, userPin)) {
            System.out.println("Welcome, " + userId + ".");
            displayMenu(scanner);
        } else {
            System.out.println("Invalid user ID or PIN. Please try again.");
            run();
        }
    }

    private boolean validateUser(String userId, String userPin) {
        // Here, you can add your own logic to validate the user.
        // For example, you can check if the user ID and PIN match a user in a database.
        return true;
    }

    private void displayMenu(Scanner scanner) {
     
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.print("Choose an option:");
          
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                displayTransactionHistory();
                displayMenu(scanner);
                break;
            case 2:
                withdraw(scanner);
                displayMenu(scanner);
                break;
            case 3:
                deposit(scanner);
                displayMenu(scanner);
                break;
            case 4:
                transfer(scanner);
                displayMenu(scanner);
                break;
            case 5:
                quit();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                displayMenu(scanner);
                break;
        }
    }

    private void displayTransactionHistory() {
        System.out.println("Transactions History:");
        System.out.println("Number of transactions: " + transactions);
        // Here, you can add your own logic to display the transaction history.
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount <= balance) {
            balance -= amount;
            transactions++;
            System.out.println("Withdrawn " + amount + " successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        int amount = scanner.nextInt();

        balance += amount;
        transactions++;
        System.out.println("Deposited " + amount + " successfully.");
    }

    private void transfer(Scanner scanner) {
        System.out.print("Enter the amount to transfer: ");
        int amount = scanner.nextInt();

        if (amount <= balance) {
            balance -= amount;
            transactions++;
            System.out.println("Transferred " + amount + " successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void quit() {
        System.out.println("Thank you for using the ATM.");
        System.exit(0);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
