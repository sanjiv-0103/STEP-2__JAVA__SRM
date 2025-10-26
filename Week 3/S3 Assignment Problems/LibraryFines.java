class Book {
    private static int bid = 1;
    private String id, title, author, category;
    private boolean issued = false;
    private int issueDay = 0, dueDay = 0;

    public Book(String t, String a, String c) {
        id = "BK" + String.format("%03d", bid++);
        title = t;
        author = a;
        category = c;
    }

    public boolean isIssued() {
        return issued;
    }

    public String getId() {
        return id;
    }

    public int getDueDay() {
        return dueDay;
    }

    public boolean issue(int today, int due) {
        if (issued)
            return false;
        issued = true;
        issueDay = today;
        dueDay = due;
        return true;
    }

    public int returnAndGetOverdueDays(int today) {
        if (!issued)
            return 0;
        issued = false;
        return Math.max(0, today - dueDay);
    }

    public void display() {
        System.out.println(id + " | " + title + " | " + author + " | " + category + " | Issued:" + issued);
    }
}

class Member {
    private static int mid = 1;
    private String id, name, type;
    private Book[] books;
    private int count = 0;

    public Member(String n, String t, int maxBooks) {
        id = "MB" + String.format("%03d", mid++);
        name = n;
        type = t;
        books = new Book[maxBooks];
    }

    public String getType() {
        return type;
    }

    public boolean addBook(Book b) {
        if (count == books.length || b.isIssued())
            return false;
        books[count++] = b;
        return true;
    }

    public boolean removeBook(String bookId) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId().equals(bookId)) {
                books[i] = books[--count];
                return true;
            }
        }
        return false;
    }

    public void display() {
        System.out.print(id + " | " + name + " (" + type + ") | Books: ");
        for (int i = 0; i < count; i++)
            System.out.print(books[i].getId() + " ");
        if (count == 0)
            System.out.print("None");
        System.out.println();
    }
}

public class LibraryFines {
    static double finePerDay = 2.0;
    static int maxBooksStudent = 2, maxBooksFaculty = 5, maxBooksGeneral = 3;

    static int today = 10;

    static double calculateFine(int overdueDays) {
        return overdueDays * finePerDay;
    }

    public static void main(String[] args) {
        Book b1 = new Book("Clean Code", "Martin", "CS");
        Book b2 = new Book("Algorithms", "Sedgewick", "CS");
        Book b3 = new Book("History of Art", "Gombrich", "Arts");

        Member m1 = new Member("Alice", "Student", maxBooksStudent);
        Member m2 = new Member("Prof. Bob", "Faculty", maxBooksFaculty);
        if (b1.issue(5, 8) && m1.addBook(b1)) {
        }
        if (b2.issue(7, 12) && m2.addBook(b2)) {
        }
        int odays = b1.returnAndGetOverdueDays(today);
        m1.removeBook(b1.getId());
        double fine = calculateFine(odays);
        b1.display();
        b2.display();
        b3.display();
        m1.display();
        m2.display();
        System.out.println("Fine for Alice on BK001: Rs. " + fine);
    }
}
