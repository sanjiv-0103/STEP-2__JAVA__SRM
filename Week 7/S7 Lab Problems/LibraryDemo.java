class LibraryUser {
    String name;

    LibraryUser(String name) {
        this.name = name;
    }

    void logEntry() {
        System.out.println(name + " entered the library.");
    }

    void showInfo() {
        System.out.println("User: " + name);
    }

    void accessPrivileges() {
        System.out.println("General browsing.");
    }
}

class Student extends LibraryUser {
    Student(String name) {
        super(name);
    }

    @Override
    void accessPrivileges() {
        System.out.println("Student: borrow books + use computers.");
    }
}

class Faculty extends LibraryUser {
    Faculty(String name) {
        super(name);
    }

    @Override
    void accessPrivileges() {
        System.out.println("Faculty: reserve books + access research databases.");
    }
}

class Guest extends LibraryUser {
    Guest(String name) {
        super(name);
    }

    @Override
    void accessPrivileges() {
        System.out.println("Guest: browse books only.");
    }
}

public class LibraryDemo {
    public static void main(String[] args) {
        LibraryUser[] users = {
                new Student("Janani"),
                new Faculty("Dr. Elan"),
                new Guest("Visitor")
        };

        for (LibraryUser u : users) {
            u.logEntry();
            u.showInfo();
            u.accessPrivileges();
            System.out.println();
        }
    }
}
