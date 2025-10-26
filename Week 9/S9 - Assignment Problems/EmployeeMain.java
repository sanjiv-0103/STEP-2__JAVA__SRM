class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Sanjiv", 50000);
        Employee e2 = new Employee(2, "Janu", 60000);
        System.out.println(e1);
        System.out.println(e1.getClass().getName());
        System.out.println(e2);
        System.out.println(e2.getClass().getName());
    }
}
