// File: EmployeeHR.java
class Employee {
    private static int eid = 1;
    private String id, name, dept, type;
    private double base;
    private boolean[] attendance = new boolean[30];

    public Employee(String n, String d, double base) {
        id = "E" + String.format("%03d", eid++);
        name = n;
        dept = d;
        type = "FULL";
        this.base = base;
    }

    public Employee(String n, String d, double hourly, int dummy) {
        id = "E" + String.format("%03d", eid++);
        name = n;
        dept = d;
        type = "PART";
        this.base = hourly;
    }

    public Employee(String n, double contract) {
        id = "E" + String.format("%03d", eid++);
        name = n;
        dept = "Contract";
        type = "CONTRACT";
        this.base = contract;
    }

    public void markAttendance(int day, boolean present) {
        if (day >= 1 && day <= 30)
            attendance[day - 1] = present;
    }

    public double calculateSalary() {
        if (type.equals("FULL"))
            return base + calculateBonus();
        if (type.equals("PART")) {
            int days = 0;
            for (boolean p : attendance)
                if (p)
                    days++;
            return base * (days * 8);
        }
        return base;
    }

    public double calculateBonus() {
        int present = 0;
        for (boolean p : attendance)
            if (p)
                present++;
        return present >= 26 ? base * 0.10 : 0;
    }

    public void generatePaySlip() {
        double gross = calculateSalary();
        double tax = type.equals("FULL") ? gross * 0.10 : type.equals("PART") ? gross * 0.05 : gross * 0.08;
        System.out.println(
                id + " | " + name + " | " + type + " | Gross:" + gross + " | Tax:" + tax + " | Net:" + (gross - tax));
    }
}

class Department {
    private String id, name;
    private Employee[] emps;
    private int count = 0;

    public Department(String id, String name, int cap) {
        this.id = id;
        this.name = name;
        emps = new Employee[cap];
    }

    public void add(Employee e) {
        if (count < emps.length)
            emps[count++] = e;
    }

    public double monthlyExpense() {
        double s = 0;
        for (int i = 0; i < count; i++)
            s += emps[i].calculateSalary();
        return s;
    }

    public void display() {
        System.out.println(id + " | " + name + " | Employees:" + count + " | Expense:" + monthlyExpense());
    }
}

public class EmployeeHR {
    public static void main(String[] args) {
        Employee e1 = new Employee("Sanjiv", "IT", 60000);
        Employee e2 = new Employee("SK", "Support", 30.0, 0);
        Employee e3 = new Employee("Dhanush", 9000);

        for (int d = 1; d <= 28; d++) {
            e1.markAttendance(d, true);
            if (d % 2 == 0)
                e2.markAttendance(d, true);
        }
        e3.markAttendance(1, true);

        Department it = new Department("D01", "IT", 5);
        it.add(e1);
        it.add(e2);
        it.add(e3);

        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();
        it.display();
    }
}
