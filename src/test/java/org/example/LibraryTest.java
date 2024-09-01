package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    // Test case to see that we can add a book
    @Test
    public void testAddBook(){
        Library library=new Library();
        Book book=new Book("123","Book Title","Author Name",2024);
        assertTrue(library.addBook(book));// check if book has unique isbn and then adds it.
        assertFalse(library.addBook(book));//checks if book does not have a unique isbn
        assertTrue(library.viewAvailableBooks().contains(book));//check if added book is available.
    }
    //test case for borrowing book
    @Test
    public void testBorrowBook() {
        Library library = new Library();
        Book book = new Book("123", "Book Title", "Author Name", 2024);
        assertTrue(library.addBook(book));// check if book has unique isbn and then adds it.
        assertEquals("Book Borrowed", library.borrowBook("123"));//check when available book is borrowed it should give appropriate message be displayed.
        assertEquals("No such book in library", library.borrowBook("12"));//checks if book is not in library then appropriate error be returned.
        assertEquals("Book not available now", library.borrowBook("123"));//checks if book is not available it should give appropriate error.
        assertFalse(book.isAvailable());//checks that after borrowing book is not available
    }
    //test cases for returning books.
    @Test
    public void testReturnBook(){
        Library library = new Library();
        Book book = new Book("123", "Book Title", "Author Name", 2024);
        assertTrue(library.addBook(book));// check if book has unique isbn and then adds it.
        assertEquals("Book Borrowed",library.borrowBook("123"));// Now we borrow that book.
        assertEquals("Book returned",library.returnBook("123"));//Checks if the borrowed book is returned
        assertTrue(book.isAvailable());//checks that after returning book is available
        assertEquals("Not found",library.returnBook("12"));//checks if book is not in library then appropriate error be returned
        assertEquals("Book wasn't Borrowed",library.returnBook("123"));//checks if book wasn't borrowed.
    }
    //test cases for Available books.
    @Test
    public void testViewAvailableBooks(){
        Library library = new Library();
        Book book1 = new Book("123", "Book Title", "Author Name", 2024);
        Book book2 = new Book("321", "Book Title", "Author Name", 2024);
        assertTrue(library.addBook(book1));// check if book has unique isbn and then adds it.
        assertTrue(library.addBook(book2));// check if book has unique isbn and then adds it.
        Collection<Book> availableBooks=library.viewAvailableBooks();
        assertTrue(availableBooks.contains(book1) && availableBooks.contains(book2));//checks if both added books are available.
        library.borrowBook("123");// we borrow book1.
        Collection<Book> availableBooks1=library.viewAvailableBooks();//getting updated list of available books
        assertTrue(availableBooks1.contains(book2));//Checks that the book 2 should be available.
        assertFalse(availableBooks1.contains(book1));//Checks that the book 1 should be unavailable.
        library.returnBook("123");// Now we return the borrowed book.
        Collection<Book> availableBooks2=library.viewAvailableBooks();//getting updated list of available books
        assertTrue(availableBooks2.contains(book1) && availableBooks2.contains(book2));//checks if both books are available after returning the borrowed one.
    }
}