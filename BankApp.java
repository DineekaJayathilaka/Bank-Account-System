class BankAccount {
    String accHolderName;
    double balance;
    static final double minimumBalance = 500;
    double annualInterest;

    public BankAccount() {
        accHolderName = null;
        balance = 0;
        annualInterest = 0;
    }

    public BankAccount(String name, double newBalance) {
        accHolderName = name;
        balance = newBalance;
        annualInterest = 0;
    }

    public void checkDeposit(double initialDeposit) {
        if (initialDeposit < minimumBalance) {
            System.out.println("Minimum balance requirement: " + minimumBalance);
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public double withdraw(double amount) {
        if (balance < amount + minimumBalance) {
            System.out.println("Insufficient balance.");
            return 0;
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return amount;
        }
    }

    public void checkBalance() {
        System.out.println("Account Holder: " + accHolderName);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String name, double newBalance) {
        super(name, newBalance);
    }

    
    public void checkBalance() {
        System.out.println("This is a savings account.");
        super.checkBalance();
    }
}

public class BankApp {
    public static void main(String[] args) {
        SavingsAccount account1 = new SavingsAccount("Perera", 100);
        SavingsAccount account2 = new SavingsAccount("Silva", 2000);

     
        account1.deposit(200);
        System.out.println("Account 1:");
        account1.checkBalance();

       
        double withdrawnAmount = account2.withdraw(400);
        if (withdrawnAmount > 0) {
            System.out.println("Withdrawn  account 2: " + withdrawnAmount);
        }
        System.out.println("Account 2:");
        account2.checkBalance();
    }
}