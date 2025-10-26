class Student {
    private static int sid = 1;
    private String id, name, cls;
    private double[] marks;

    public Student(String n, String c, double[] m) {
        id = "S" + sid++;
        name = n;
        cls = c;
        marks = m;
    }

    public double avg() {
        double sum = 0;
        for (double x : marks)
            sum += x;
        return sum / marks.length;
    }

    public String grade() {
        double p = avg();
        return p >= 90 ? "A" : p >= 80 ? "B" : p >= 70 ? "C" : p >= 60 ? "D" : "F";
    }

    public void display() {
        System.out.println(id + " | " + name + " | " + cls + " | Avg:" + avg() + " | Grade:" + grade());
    }
}

public class StudentGrades {
    public static void main(String[] args) {
        Student s1 = new Student("Sanjiv", "10A", new double[] { 90, 85, 88 });
        Student s2 = new Student("Janu", "10A", new double[] { 70, 65, 60 });
        s1.display();
        s2.display();
    }
}
