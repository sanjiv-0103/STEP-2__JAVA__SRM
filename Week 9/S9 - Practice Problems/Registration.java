class ContactInfo implements Cloneable {
    String email;
    String phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Email: " + email + ", Phone: " + phone;
    }
}

class Student implements Cloneable {
    String id;
    String name;
    ContactInfo contact;

    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Student deepClone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) contact.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return "Student[id=" + id + ", name=" + name + ", " + contact + "]";
    }
}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContactInfo c1 = new ContactInfo("alice@mail.com", "12345");
        Student s1 = new Student("S101", "Alice", c1);

        Student s2 = (Student) s1.clone();
        Student s3 = s1.deepClone();

        System.out.println("Before change:");
        System.out.println("Original: " + s1);
        System.out.println("Shallow: " + s2);
        System.out.println("Deep: " + s3);

        s1.contact.email = "changed@mail.com";

        System.out.println("\nAfter modifying original contact:");
        System.out.println("Original: " + s1);
        System.out.println("Shallow: " + s2);
        System.out.println("Deep: " + s3);
    }
}
