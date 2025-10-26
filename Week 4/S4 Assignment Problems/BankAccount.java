import java.util.Random;

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount() {
        this("Unknown", 0.0);
    }

    BankAccount(String name) {
        this.accountHolder = name;
        this.accountNumber = new Random().nextInt(90000) + 10000; // random 5-digit
        this.balance = 0.0;
    }

    BankAccount(String name, double balance) {
        this.accountHolder = name;
        this.accountNumber = new Random().nextInt(90000) + 10000;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited.");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void displayAccount() {
        System.out.println("Account Holder: " + accountHolder +
                ", Account Number: " + accountNumber +
                ", Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount("Alice");
        BankAccount acc3 = new BankAccount("Bob", 5000.0);
        acc1.displayAccount();
        acc2.displayAccount();
        acc3.displayAccount();

        acc2.deposit(2000);
        acc2.withdraw(1000);
        acc2.displayAccount();
    }
}
