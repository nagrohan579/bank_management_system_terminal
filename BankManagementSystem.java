import java.util.Scanner;

class BankAccount {
    private int balance = 0;
    private int previousTransaction;
    private String customerName;
    private int customerId;
    private Scanner sc;

    BankAccount(String cName, int cId) {
        this.sc = new Scanner(System.in);
        customerName = cName;
        customerId = cId;
    }

    int input() {
        int a = -1;
        do {
            try {
                a = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid Input!\nEnter Again:");
            } finally {
                sc.nextLine();
            }
        } while (a<0);
        return a;
    }

    void deposit() {
        System.out.println("Enter an amount to deposit:");
        int amount = input();
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw() {
        if (balance == 0) {
            System.out.println("Balance is zero!\nAdd some money first.");
            return;
        }

        System.out.println("Enter an amount to withdraw: ");
        int amount = input();

        if (amount > balance)
            System.out.println("Not enough balance!");
        else if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No Transaction occured");
        }

    }
    void displayBalance()
    {
        System.out.println("Balanace: "+balance);
    }

    void showMenu() {
        int option;

        try {
            System.out.println("Welcome " + customerName);
            System.out.println("Your Id is: " + customerId);
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Previous Transaction");
            System.out.println("5. Exit");

            do {
                System.out.println("Enter an option: ");
                option = input();

                switch (option) {
                    case 1 -> displayBalance();
                    case 2 -> deposit();
                    case 3 -> withdraw();
                    case 4 -> getPreviousTransaction();
                    case 5 -> System.out.println("******************");
                    default -> System.out.println("Invalid input!");
                }
            } while (option != 5);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

}

public class BankManagementSystem {
    public static void main(String[] args) {
        BankAccount ob = new BankAccount("Ronita", 987);
        ob.showMenu();
    }
}