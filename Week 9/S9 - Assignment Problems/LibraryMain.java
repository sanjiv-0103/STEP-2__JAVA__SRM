import java.util.*;

class Book implements Cloneable {
    String title;

    Book(String title) {
        this.title = title;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Library implements Cloneable {
    List<Book> books = new ArrayList<>();

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    Library deepClone() throws CloneNotSupportedException {
        Library copy = new Library();
        for (Book b : books)
            copy.books.add((Book) b.clone());
        return copy;
    }
}

public class LibraryMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Library lib1 = new Library();
        lib1.books.add(new Book("Java"));
        Library shallow = (Library) lib1.clone();
        Library deep = lib1.deepClone();
        shallow.books.get(0).title = "C++";
        System.out.println(lib1.books.get(0).title);
        System.out.println(deep.books.get(0).title);
    }
}
