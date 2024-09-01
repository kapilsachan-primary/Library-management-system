package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    // Test case to see that we can add a book
    @Test
    public void testAddBook(){
        Library library=new Library();
        Book book=new Book("123","Book Title","Author Name",2024);
        assertTrue(library.addBook(book));// check if book has unique isbn
        assertFalse(library.addBook(book));//checks if book does not have a unique isbn
        assertTrue(library.viewAvailableBooks().contains(book));//check if added book is available.
    }
    //test case for borrowing book
    @Test
    public void testBorrowBook() {
        Library library = new Library();
        Book book = new Book("123", "Book Title", "Author Name", 2024);
        assertTrue(library.addBook(book));// check if book has unique isbn
        assertEquals("Book Borrowed", library.borrowBook("123"));//check when available book is borrowed it should give appropriate message be displayed.
        assertEquals("No such book in library", library.borrowBook("12"));//checks if book is not in library then appropriate error br returned.
        assertEquals("Book not available now", library.borrowBook("123"));//checks if book is not available it should give appropriate error.
        assertFalse(book.isAvailable());//checks that after borrowing book is not available
    }
}