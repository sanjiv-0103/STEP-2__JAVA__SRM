class Book {
    String title, author, isbn;
    boolean isAvailable;

    Book() {
        this("", "", "", true);
    }

    Book(String title, String author) {
        this(title, author, "N/A", true);
    }

    Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println(title + " returned.");
    }

    void displayBookInfo() {
        System.out.println("Title: " + title +
                ", Author: " + author +
                ", ISBN: " + isbn +
                ", Available: " + isAvailable);
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("Java Basics", "James Gosling", "12345", true);

        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();

        b2.borrowBook();
        b2.displayBookInfo();

        b2.returnBook();
        b2.displayBookInfo();
    }
}
