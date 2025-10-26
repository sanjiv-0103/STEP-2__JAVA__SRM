class Patient {
    private static int pid = 1;
    String id, name, gender, contact;
    String[] history = new String[5];
    int hCount = 0;

    public Patient(String n, String g, String c) {
        id = "P" + String.format("%03d", pid++);
        name = n;
        gender = g;
        contact = c;
    }

    public void addHistory(String note) {
        if (hCount < history.length)
            history[hCount++] = note;
    }

    public void display() {
        System.out.println(id + " | " + name + " | " + gender + " | " + contact);
    }
}

class Doctor {
    private static int did = 1;
    String id, name, specialization;
    String[] slots;
    int handled = 0;
    double fee;

    public Doctor(String n, String s, double fee, String[] slots) {
        id = "D" + String.format("%03d", did++);
        name = n;
        specialization = s;
        this.fee = fee;
        this.slots = slots;
    }

    public void display() {
        System.out.println(id + " | " + name + " | " + specialization + " | Patients:" + handled);
    }
}

class Appointment {
    private static int aid = 1;
    static int totalAppointments = 0;
    static double totalRevenue = 0;
    String id, date, time, type;
    Patient p;
    Doctor d;
    String status = "Scheduled";
    double bill = 0;

    public Appointment(Patient p, Doctor d, String date, String time, String type) {
        id = "A" + String.format("%03d", aid++);
        this.p = p;
        this.d = d;
        this.date = date;
        this.time = time;
        this.type = type;
        totalAppointments++;
    }

    public void cancel() {
        status = "Canceled";
    }

    public void generateBill() {
        double mult = type.equalsIgnoreCase("Emergency") ? 1.5 : type.equalsIgnoreCase("FollowUp") ? 0.5 : 1.0;
        bill = d.fee * mult;
        totalRevenue += bill;
        d.handled++;
    }

    public void display() {
        System.out.println(id + " | " + p.name + " -> " + d.name + " | " + date + " " + time + " | " + type + " | "
                + status + " | Bill:" + bill);
    }

    public static void report() {
        System.out.println("Total Appointments: " + totalAppointments + " | Revenue: Rs. " + totalRevenue);
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Patient p1 = new Patient("Geetha", "F", "99999");
        Doctor d1 = new Doctor("Dr. Elankumaran", "Cardiology", 1000, new String[] { "10:00", "11:00", "12:00" });

        Appointment a1 = new Appointment(p1, d1, "2025-09-01", "10:00", "Consultation");
        a1.generateBill();

        p1.addHistory("Chest pain - advised ECG");
        p1.display();
        d1.display();
        a1.display();
        Appointment.report();

        Appointment a2 = new Appointment(p1, d1, "2025-09-10", "11:00", "FollowUp");
        a2.generateBill();
        a2.display();
        Appointment.report();
    }
}
