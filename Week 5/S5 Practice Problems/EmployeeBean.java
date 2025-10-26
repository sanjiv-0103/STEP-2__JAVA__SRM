import java.util.Date;

public class EmployeeBean implements java.io.Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    public EmployeeBean() {
    } // no-arg constructor

    public EmployeeBean(String id, String f, String l, double s, String d, Date h, boolean a) {
        this.employeeId = id;
        this.firstName = f;
        this.lastName = l;
        this.salary = s;
        this.department = d;
        this.hireDate = h;
        this.isActive = a;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String id) {
        this.employeeId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String f) {
        this.firstName = f;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String l) {
        this.lastName = l;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double s) {
        if (s > 0)
            this.salary = s;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String d) {
        this.department = d;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date h) {
        this.hireDate = h;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean a) {
        this.isActive = a;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return employeeId + " - " + getFullName() + " | " + department + " | $" + salary;
    }

    public static void main(String[] args) {
        EmployeeBean emp = new EmployeeBean("E101", "Janani", "Geetha", 50000, "IT", new Date(), true);
        System.out.println(emp);
        emp.setSalary(60000);
        System.out.println("Updated Salary: " + emp.getSalary());
    }
}
