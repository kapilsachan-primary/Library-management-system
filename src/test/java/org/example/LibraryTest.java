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
}