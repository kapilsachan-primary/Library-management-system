package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Library {
    // Using hashmap to store the details and isbn number of book in key value pairs.
    private final Map<String,Book> books=new HashMap<>();

    public boolean addBook(Book book){
        if(books.containsKey(book.getIsbn()))
            return false; // if library has a book with this isbn already then it wont allow to insert this book.
        books.put(book.getIsbn(), book);
        return true;
    }
    public String borrowBook(String isbn){
        Book book=books.get(isbn);
        if(book==null)
            return "No such book in library";
        else if (!book.isAvailable()) {
            return "Book not available now";
        }
        else{
            book.setAvailable(false);
            return "Book Borrowed";
        }
    }
    // Will check if the book has the status of not available it will be returned or appropriate error will be returned.
    public String returnBook(String isbn){
        Book book=books.get(isbn);
        if(book==null){
            return "Not found";
        } else if (book.isAvailable()) {
            return "Book wasn't Borrowed";
        }
        else{
            book.setAvailable(true);
            return "Book returned";
        }
    }
    // here we take the details of all books convert then to stream so we can perform filter on them
    // on the basis of  availability and convert them into list to return them.
    public Collection<Book> viewAvailableBooks(){
        return books.values().stream()
                .filter(Book::isAvailable)
                .toList();
    }
}
