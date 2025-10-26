class MedicalStaff {
    void work() {
        System.out.println("General hospital duty");
    }
}

class Doctor extends MedicalStaff {
    void work() {
        System.out.println("Doctor treating patients");
    }
}

class Nurse extends MedicalStaff {
    void work() {
        System.out.println("Nurse giving medicine");
    }
}

public class Hospital {
    public static void main(String[] args) {
        MedicalStaff s = new Doctor();
        s.work();
        s = new Nurse();
        s.work();
    }
}