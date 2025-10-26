public class BankAccount {
    static String bankName;
    static int totalAccounts = 0;
    static double interestRate;

    String accountNumber;
    String accountHolder;
    double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank: " + bankName + ", Total Accounts: " + totalAccounts);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount)
            balance -= amount;
    }

    public double calculateInterest() {
        return balance * interestRate / 100;
    }

    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount.setBankName("Axis Bank");
        BankAccount.setInterestRate(5.0);

        BankAccount acc1 = new BankAccount("101", "Janani", 1000);
        BankAccount acc2 = new BankAccount("102", "Sanjiv", 2000);

        acc1.deposit(500);
        acc1.displayAccountInfo();
        System.out.println("Interest: " + acc1.calculateInterest());

        acc2.withdraw(300);
        acc2.displayAccountInfo();

        BankAccount.displayBankInfo();
    }
}
