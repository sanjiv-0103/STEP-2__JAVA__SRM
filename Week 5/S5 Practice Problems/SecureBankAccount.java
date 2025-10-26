public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private int failedAttempts = 0;

    public SecureBankAccount(String accNo, double initialBalance) {
        this.accountNumber = accNo;
        this.balance = initialBalance;
        this.pin = 0;
        this.isLocked = false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance(int pin) {
        return validatePin(pin) ? balance : -1;
    }

    public void setPin(int oldPin, int newPin) {
        if (this.pin == oldPin)
            this.pin = newPin;
        else
            System.out.println("Incorrect old PIN");
    }

    private boolean validatePin(int enteredPin) {
        if (enteredPin == pin) {
            failedAttempts = 0;
            return true;
        } else {
            failedAttempts++;
            if (failedAttempts >= MAX_FAILED_ATTEMPTS)
                isLocked = true;
            return false;
        }
    }

    public void deposit(double amount, int pin) {
        if (!isLocked && validatePin(pin))
            balance += amount;
    }

    public void withdraw(double amount, int pin) {
        if (!isLocked && validatePin(pin) && amount <= balance)
            balance -= amount;
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("12345", 5000);
        acc1.setPin(0, 1234);
        acc1.deposit(1000, 1234);
        System.out.println("Balance: " + acc1.getBalance(1234));
        acc1.withdraw(2000, 1234);
        System.out.println("Balance after withdrawal: " + acc1.getBalance(1234));
    }
}
