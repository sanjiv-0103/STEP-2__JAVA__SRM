public class Student {
    private String studentId;
    private String name;
    private double grade;
    private String course;

    public Student() {
    }

    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public String getCourse() {
        return course;
    }

    public String calculateLetterGrade() {
        if (grade >= 90)
            return "A";
        else if (grade >= 80)
            return "B";
        else if (grade >= 70)
            return "C";
        else if (grade >= 60)
            return "D";
        else
            return "F";
    }

    public void displayStudent() {
        System.out.println("ID: " + studentId + ", Name: " + name + ", Course: " + course + ", Grade: " + grade + " ("
                + calculateLetterGrade() + ")");
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setStudentId("S001");
        s1.setName("Janani");
        s1.setGrade(85);
        s1.setCourse("Java Programming");

        Student s2 = new Student("S002", "Sanjiv", 92, "Python Programming");

        s1.displayStudent();
        s2.displayStudent();
    }
}