class PersonalAccount {
    private static int counter = 1;
    private static String bankName = "Simple Bank";
    private static int totalAccounts = 0;

    private String accountNumber;
    private String holder;
    private double balance, income, expense;

    public PersonalAccount(String holder) {
        this.holder = holder;
        this.accountNumber = "ACC" + String.format("%03d", counter++);
        totalAccounts++;
    }

    public void addIncome(double amt) {
        balance += amt;
        income += amt;
    }

    public void addExpense(double amt) {
        if (balance >= amt) {
            balance -= amt;
            expense += amt;
        }
    }

    public double calculateSavings() {
        return income - expense;
    }

    public void display() {
        System.out.println(accountNumber + " | " + holder + " | Bal: " + balance +
                " | Income: " + income + " | Expense: " + expense + " | Savings: " + calculateSavings());
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static void showBank() {
        System.out.println(bankName + " | Accounts: " + totalAccounts);
    }
}

public class PersonalFinance {
    public static void main(String[] args) {
        PersonalAccount a1 = new PersonalAccount("Janani");
        PersonalAccount a2 = new PersonalAccount("Sanjiv");
        a1.addIncome(5000);
        a1.addExpense(1200);
        a2.addIncome(3000);
        a2.addExpense(1000);
        a1.display();
        a2.display();
        PersonalAccount.showBank();
    }
}
