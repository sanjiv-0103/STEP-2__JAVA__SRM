class BankAccount {
    private static int counter = 1;
    private static int totalAccounts = 0;
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String holderName, double initialDeposit) {
        this.accountHolderName = holderName;
        this.accountNumber = generateAccountNumber();
        this.balance = Math.max(0, initialDeposit);
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance)
            balance -= amount;
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccountInfo() {
        System.out.println("[" + accountNumber + "] " + accountHolderName
                + " | Balance: " + balance);
    }

    private static String generateAccountNumber() {
        String id = String.format("ACC%03d", counter);
        counter++;
        return id;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = new BankAccount("Janani", 1000);
        accounts[1] = new BankAccount("Sanjiv", 500);
        accounts[2] = new BankAccount("Dhakshi", 0);

        accounts[0].deposit(250);
        accounts[1].withdraw(100);
        accounts[2].deposit(700);

        for (int i = 0; i < accounts.length; i++) {
            accounts[i].displayAccountInfo();
        }

        System.out.println("Total accounts: " + BankAccount.getTotalAccounts());
    }
}
