// hello first change
// second change
package org.example;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final int publicationYear;
    private boolean available;

    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
    }
    // Getter method to get specific details of a book instance
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean avail) {
        this.available = avail;
    }
}
