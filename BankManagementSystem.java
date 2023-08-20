class BankAccount 
{
    int balance=0;
    int previousTransaction;
    void deposit(int amount)
    {
        if(amount!=0)
        {
            balance=balance+amount;
            previousTransaction=amount;
        }
        System.out.println("Deposited: "+amount);
        System.out.println("Current balance: "+balance);
    }
    void withdraw(int amount)
    {
        if(amount!=0)
        {
            balance=balance-amount;
            previousTransaction= -amount;
        }
        System.out.println("Withdrawn: "+amount);
        System.out.println("current balance: "+balance);
    }
    

}


public class BankManagementSystem {
    public static void main(String[] args) {
        BankAccount ob=new BankAccount();
        ob.deposit(10000);
        ob.withdraw(5000);
    }
}