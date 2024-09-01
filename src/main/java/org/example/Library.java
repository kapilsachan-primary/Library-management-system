package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Library {
    // Using hashmap to store the details and isbn number of book in key value pairs.
    private final Map<String,Book> books=new HashMap<>();

    public void addBook(Book book){
        books.put(book.getIsbn(), book);
    }
    // here we take the details of all books convert then to stream so we can perform filter on them
    // on the basis of  availability and convert them into list to return them.
    public Collection<Book> viewAvailableBooks(){
        return books.values().stream()
                .filter(Book::isAvailable)
                .toList();
    }
}
