package entity.concrete;

import entity.AbstractPerson;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Author extends AbstractPerson {
    private final Set<Book> books = new HashSet<>();

    public Author(Long id, String name, Address address, String phoneNumber, String email) {
        super(id, name, address, phoneNumber, email);
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }

    public void addBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("Book argument cannot be null");
        if (!book.getAuthor().equals(this))
            throw new IllegalArgumentException("This book has written by another author");
        this.books.add(book);
    }

    @Override
    public String toString() {
        return "Author " + getName() + " has written " + books;
    }
}
