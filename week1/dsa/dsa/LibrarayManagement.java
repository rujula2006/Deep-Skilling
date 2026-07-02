class Book {

    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println();
    }
}

class SearchBook {

    public Book linearSearch(Book[] books, String title) {

        for (int i = 0; i < books.length; i++) {

            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }

        return null;
    }

    public Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = books[mid].getTitle().compareToIgnoreCase(title);

            if (result == 0) {
                return books[mid];
            }

            if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}

public class LibrarayManagement {

    public static void main(String[] args) {

        Book[] books = {
                new Book(101, "C Programming", "Dennis Ritchie"),
                new Book(102, "Data Structures", "Mark Allen"),
                new Book(103, "Java Programming", "Herbert Schildt"),
                new Book(104, "Python Basics", "John Zelle"),
                new Book(105, "Web Development", "Jon Duckett")
        };

        SearchBook searchBook = new SearchBook();

        System.out.println("Linear Search:");

        Book book1 = searchBook.linearSearch(books, "Java Programming");

        if (book1 != null) {
            book1.displayBook();
        } else {
            System.out.println("Book not found");
        }

        System.out.println("Binary Search:");

        Book book2 = searchBook.binarySearch(books, "Java Programming");

        if (book2 != null) {
            book2.displayBook();
        } else {
            System.out.println("Book not found");
        }
    }
}