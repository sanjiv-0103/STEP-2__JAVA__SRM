import java.time.LocalDate;
import java.util.Arrays;

final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA,
            String[] allergies, String[] medicalHistory,
            LocalDate birthDate, String bloodType) {
        if (recordId == null || recordId.isEmpty())
            throw new IllegalArgumentException("recordId required");
        if (patientDNA == null || patientDNA.isEmpty())
            throw new IllegalArgumentException("DNA required");
        if (birthDate == null)
            throw new IllegalArgumentException("birthDate required");
        if (bloodType == null || bloodType.isEmpty())
            throw new IllegalArgumentException("bloodType required");
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = allergies == null ? new String[0] : allergies.clone();
        this.medicalHistory = medicalHistory == null ? new String[0] : medicalHistory.clone();
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() {
        return recordId;
    }

    public String getPatientDNA() {
        return patientDNA;
    }

    public String[] getAllergies() {
        return allergies.clone();
    }

    public String[] getMedicalHistory() {
        return medicalHistory.clone();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public final boolean isAllergicTo(String substance) {
        if (substance == null)
            return false;
        for (String a : allergies) {
            if (substance.equalsIgnoreCase(a))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "MedicalRecord{id=" + recordId + ", bloodType=" + bloodType +
                ", allergies=" + Arrays.toString(allergies) + "}";
    }
}

class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord; // PHI
    private String currentName;
    private String emergencyContact;
    private int roomNumber;

    public Patient(String patientId, String name, MedicalRecord record) {
        if (patientId == null || patientId.isEmpty())
            throw new IllegalArgumentException("patientId required");
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("name required");
        if (record == null)
            throw new IllegalArgumentException("medical record required");
        this.patientId = patientId;
        this.currentName = name;
        this.medicalRecord = record;
        this.roomNumber = 0;
    }

    public void setEmergencyContact(String contact) {
        this.emergencyContact = contact;
    }

    public void setRoomNumber(int room) {
        if (room >= 0)
            this.roomNumber = room;
    }

    public String getPublicInfo() {
        return "Patient{name='" + currentName + "', room=" + roomNumber + "}";
    }

    String getBasicInfo() {
        return "ID=" + patientId + ", name=" + currentName + ", room=" + roomNumber;
    }

    public boolean hasAllergy(String substance) {
        return medicalRecord.isAllergicTo(substance);
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        MedicalRecord rec = new MedicalRecord(
                "MR-1001", "DNA-XYZ",
                new String[] { "Penicillin", "Peanuts" },
                new String[] { "Asthma" },
                java.time.LocalDate.of(2000, 5, 10),
                "O+");
        Patient p = new Patient("P-01", "Asha", rec);
        p.setEmergencyContact("Dad: 9876543210");
        p.setRoomNumber(203);

        System.out.println(p.getPublicInfo());
        System.out.println("Allergic to Peanuts? " + p.hasAllergy("peanuts"));
    }
}
