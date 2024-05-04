package Exam2Prep;

class Book {
    private String title;
    private String author;
    private int pageCount;

    public Book(String title, String author, int pageCount) {
        setTitle(title);
        setAuthor(author);
        setPageCount(pageCount);
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Page Count: " + pageCount);
    }

    public void setTitle(String newTitle) {
        title = newTitle;
    }
    
    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }
    public void setPageCount(int newPage) {
        pageCount = newPage;
    }
}

class Library {
    private Book[] books;
    private int bookCount;

    public Library(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void displayBooks() {
        for (int i = 0; i < bookCount; i++) {
            books[i].displayBookInfo();
            System.out.println();
        }
    }
}

public class myLib {
    public static void main(String[] args) 
    {
      Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 281);
      Book book2 = new Book("1984", "George Orwell", 328);

      book1.displayBookInfo();
      System.out.println();
      book2.displayBookInfo();
      System.out.println();
      
      book2.setAuthor("Eric Blair");
      book2.displayBookInfo();
      System.out.println();

      Library myLibrary = new Library(2);
      myLibrary.addBook(book1);
      myLibrary.addBook(book2);

      myLibrary.displayBooks();
    }
    
}
