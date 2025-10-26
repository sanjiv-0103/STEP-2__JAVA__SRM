class Employee {
    private static int empCounter = 1;
    private static int totalEmployees = 0;

    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;

    public Employee(String name, String dept, double base) {
        this.empId = String.format("EM%03d", empCounter++);
        this.empName = name;
        this.department = dept;
        this.baseSalary = base;
        this.empType = "FULL";
        totalEmployees++;
    }

    public Employee(String name, String dept, double hourlyRate, int hoursPerMonth) {
        this.empId = String.format("EM%03d", empCounter++);
        this.empName = name;
        this.department = dept;
        this.baseSalary = hourlyRate;
        this.empType = "PART";
        totalEmployees++;
    }

    public Employee(String name, double contractAmount) {
        this.empId = String.format("EM%03d", empCounter++);
        this.empName = name;
        this.department = "Contract";
        this.baseSalary = contractAmount;
        this.empType = "CONTRACT";
        totalEmployees++;
    }

    public double calculateSalary(double bonus) {
        return baseSalary + Math.max(0, bonus);
    }

    public double calculateSalary(int hoursWorked) {
        return baseSalary * Math.max(0, hoursWorked);
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public double calculateTax(double gross, String type) {
        double rate = type.equals("FULL") ? 0.10 : (type.equals("PART") ? 0.05 : 0.08);
        return gross * rate;
    }

    public void generatePaySlip(double amount) {
        double tax = calculateTax(amount, empType);
        System.out.println(empId + " | " + empName + " | " + empType
                + " | Gross: " + amount + " | Tax: " + tax + " | Net: " + (amount - tax));
    }

    public void displayEmployeeInfo() {
        System.out.println(empId + " | " + empName + " | " + department + " | Type: " + empType);
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }
}

public class EmployeePayroll {
    public static void main(String[] args) {
        Employee e1 = new Employee("Sanju", "IT", 60000);
        Employee e2 = new Employee("Mano", "Support", 30.0, 0);
        Employee e3 = new Employee("Janu", 9000);

        e1.displayEmployeeInfo();
        e2.displayEmployeeInfo();
        e3.displayEmployeeInfo();

        double s1 = e1.calculateSalary(5000);
        double s2 = e2.calculateSalary(80);
        double s3 = e3.calculateSalary();

        e1.generatePaySlip(s1);
        e2.generatePaySlip(s2);
        e3.generatePaySlip(s3);

        System.out.println("Total employees: " + Employee.getTotalEmployees());
    }
}
