class BankAccount {
    private String accountNumber;
    private double balance;
    private int pin;

    public BankAccount(String accountNumber, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public boolean validatePin(int enteredPin) {
        return enteredPin == pin;
    }

    public void debit(double amount) {
        balance -= amount;
        System.out.println("₹" + amount + " withdrawn. Remaining balance: ₹" + balance);
    }
}

class ATM {
    private BankAccount linkedAccount;

    public ATM(BankAccount linkedAccount) {
        this.linkedAccount = linkedAccount;
    }

    public void withdraw(int enteredPin, double amount) {
        if (linkedAccount.validatePin(enteredPin)) {
            linkedAccount.debit(amount);
            System.out.println("Transaction successful.");
        } else {
            System.out.println("Invalid PIN. Transaction failed.");
        }
    }
}

class Customer {
    private String name;
    private ATM atm;

    public Customer(String name, ATM atm) {
        this.name = name;
        this.atm = atm;
    }

    public void performWithdrawal(int pin, double amount) {
        System.out.println(name + " is requesting withdrawal...");
        atm.withdraw(pin, amount);
    }
}

public class ATMDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("12345", 10000, 1234);
        ATM atm = new ATM(acc);
        Customer c = new Customer("Ravi", atm);
        c.performWithdrawal(1234, 3000);
        c.performWithdrawal(1111, 2000);
    }
}
