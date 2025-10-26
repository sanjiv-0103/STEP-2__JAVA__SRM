class Student {
    private String name;
    private int age;
    private String course;

    public Student() {
        this("Unknown", 18, "Undeclared");
    }

    public Student(String name) {
        this(name, 18, "Undeclared");
    }

    public Student(String name, int age) {
        this(name, age, "Undeclared");
    }

    public Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}

public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Alice");
        Student s3 = new Student("Bob", 20);
        Student s4 = new Student("Charlie", 22, "Computer Science");

        s1.display();
        s2.display();
        s3.display();
        s4.display();
    }
}