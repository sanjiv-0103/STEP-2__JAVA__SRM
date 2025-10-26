class University {
    String uniName = "Adelaide University";

    class Department {
        void showDept() {
            System.out.println("Department of Engineering, " + uniName);
        }
    }

    static class ExamCell {
        static void showExamCell() {
            System.out.println("Exam Cell active for all departments.");
        }
    }
}

public class UniversityMain {
    public static void main(String[] args) {
        University u = new University();
        University.Department d = u.new Department();
        d.showDept();
        University.ExamCell.showExamCell();
    }
}
