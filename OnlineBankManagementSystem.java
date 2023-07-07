import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class BankManagementSystem {
    private List<BankAccount> accounts;

    public BankManagementSystem() {
        accounts = new ArrayList<>();
    }

    public void openAccount(String accountNumber, String accountHolderName) {
        BankAccount account = new BankAccount(accountNumber, accountHolderName);
        accounts.add(account);
        System.out.println("Account opened successfully");
    }

    public void closeAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accounts.remove(account);
                System.out.println("Account closed successfully");
                return;
            }
        }
        System.out.println("Account not found");
    }

    public void deposit(String accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.deposit(amount);
                System.out.println("Amount deposited successfully");
                return;
            }
        }
        System.out.println("Account not found");
    }

    public void withdraw(String accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.withdraw(amount);
                System.out.println("Amount withdrawn successfully");
                return;
            }
        }
        System.out.println("Account not found");
    }

    public void displayAccountDetails(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Account Holder Name: " + account.getAccountHolderName());
                System.out.println("Balance: " + account.getBalance());
                return;
            }
        }
        System.out.println("Account not found");
    }
}

public class OnlineBankManagementSystem {
    public static void main(String[] args) {
        BankManagementSystem bankSystem = new BankManagementSystem();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("----- Online Bank Management System -----");
                System.out.println("1. Open Account");
                System.out.println("2. Close Account");
                System.out.println("3. Deposit");
                System.out.println("4. Withdraw");
                System.out.println("5. Display Account Details");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Account Number: ");
                        String accountNumber = scanner.next();
                        System.out.print("Enter Account Holder Name: ");
                        String accountHolderName = scanner.next();
                        bankSystem.openAccount(accountNumber, accountHolderName);
                        break;
                    case 2:
                        System.out.print("Enter Account Number: ");
                        accountNumber = scanner.next();
                        bankSystem.closeAccount(accountNumber);
                        break;
                    case 3:
                        System.out.print("Enter Account Number: ");
                        accountNumber = scanner.next();
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = scanner.nextDouble();
                        bankSystem.deposit(accountNumber, depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter Account Number: ");
                        accountNumber = scanner.next();
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        bankSystem.withdraw(accountNumber, withdrawAmount);
                        break;
                    case 5:
                        System.out.print("Enter Account Number: ");
                        accountNumber = scanner.next();
                        bankSystem.displayAccountDetails(accountNumber);
                        break;
                    case 6:
                        System.out.println("Thank you for using the Online Bank Management System");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
                System.out.println();
            }
        }
    }
}
