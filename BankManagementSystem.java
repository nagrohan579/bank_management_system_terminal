import java.util.Scanner;

class BankAccount 
{
    int balance=0;
    int previousTransaction;
    String customerName;
    int customerId;
    BankAccount(String cName,int cId)
    {
        customerName=cName;
        customerId=cId;
    }
    void deposit(int amount)
    {
        if(amount!=0)
        {
            balance=balance+amount;
            previousTransaction=amount;
        }
        // System.out.println("Deposited: "+amount);
        // System.out.println("Current balance: "+balance);
    }
    void withdraw(int amount)
    {
        if(amount!=0)
        {
            balance=balance-amount;
            previousTransaction= -amount;
        }
        // System.out.println("Withdrawn: "+amount);
        // System.out.println("current balance: "+balance);
    }
    void getPreviousTransaction()
    {
        if(previousTransaction>0)
        {
            System.out.println("Deposited: "+previousTransaction);
        }
        else if(previousTransaction<0)
        {
            System.out.println("withdrawn: "+Math.abs(previousTransaction));
        }
        else
        {
            System.out.println("No Transaction occured");
        }
        
    }
    void showMenu()
    {
        int option;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Welcome "+customerName);
            System.out.println("Your Id is: "+customerId);
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Previous Transaction");
            System.out.println("5. Exit");

            do{
                System.out.println("Enter an option: ");
                option=sc.nextInt();

                switch(option)
                {
                    case 1:
                        System.out.println("Balance: "+balance);
                        break;
                    case 2:
                        System.out.println("Enter an amount to deposit:");
                        int amount=sc.nextInt();
                        deposit(amount);
                        break;
                    case 3:
                        System.out.println("Enter an amount to withdraw: ");
                        int amount2=sc.nextInt();
                        withdraw(amount2);
                        break;
                    case 4:
                        getPreviousTransaction();
                        break;
                    case 5:
                        System.out.println("******************");
                        break;
                    default:
                        System.out.println("Invalid position");
                        break;
                }


            }while(option!=5);
        } 
        finally{
            sc.close();
        }
    }
    

}


public class BankManagementSystem {
    public static void main(String[] args) {
        BankAccount ob=new BankAccount("Ronita",987);
        ob.showMenu();
    }
}