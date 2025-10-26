class Book {
    private static int idCounter = 1;
    private String bookId, title, author;
    private boolean isAvailable = true;

    public Book(String title, String author) {
        this.bookId = "BK" + String.format("%03d", idCounter++);
        this.title = title;
        this.author = author;
    }

    public boolean issueBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        }
        return false;
    }

    public void displayBook() {
        System.out.println(bookId + " | " + title + " | " + author + " | " + (isAvailable ? "Available" : "Issued"));
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

class Member {
    private static int idCounter = 1;
    private String memberId, name;
    private String[] booksIssued;
    private int count = 0;

    public Member(String name, int maxBooks) {
        this.memberId = "MB" + String.format("%03d", idCounter++);
        this.name = name;
        this.booksIssued = new String[maxBooks];
    }

    public boolean borrow(Book b) {
        if (count < booksIssued.length && b.issueBook()) {
            booksIssued[count++] = b.getBookId();
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookId, Book[] allBooks) {
        for (int i = 0; i < count; i++) {
            if (booksIssued[i].equals(bookId)) {
                for (Book b : allBooks)
                    if (b != null && b.getBookId().equals(bookId))
                        b.returnBook();
                booksIssued[i] = booksIssued[--count];
                return true;
            }
        }
        return false;
    }

    public void display() {
        System.out.print(memberId + " | " + name + " | Books: ");
        for (int i = 0; i < count; i++)
            System.out.print(booksIssued[i] + " ");
        if (count == 0)
            System.out.print("None");
        System.out.println();
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book[] books = { new Book("Clean Code", "JK Rowling"), new Book("Java", "Arora") };
        Member m1 = new Member("sanjiv", 2), m2 = new Member("Janu", 2);
        m1.borrow(books[0]);
        m2.borrow(books[1]);
        m2.borrow(books[0]); // Bob fails on 0
        m1.display();
        m2.display();
        for (Book b : books)
            b.displayBook();
        m1.returnBook("BK001", books);
        m1.display();
        m2.display();
        for (Book b : books)
            b.displayBook();
    }
}
