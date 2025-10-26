import java.util.*;

class Student {
    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student s = (Student) o;
        return rollNo == s.rollNo;
    }

    public int hashCode() {
        return Objects.hash(rollNo);
    }

    public String toString() {
        return rollNo + " " + name;
    }
}

public class StudentMain {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student(1, "John"));
        set.add(new Student(1, "John"));
        System.out.println(set);
    }
}
