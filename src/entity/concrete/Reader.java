package entity.concrete;

import entity.AbstractPerson;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Reader extends AbstractPerson {
    private final Set<Book> books = new HashSet<>();

    public Reader(Long id, String name, Address address, String phoneNumber, String email) {
        super(id, name, address, phoneNumber, email);
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }

    public void addBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("Book argument cannot be null");
        if (books.size() >= 5)
            throw new IllegalStateException("Reader cannot lend more than five books");
        this.books.add(book);
    }

    public void removeBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("Book argument cannot be null");
        this.books.remove(book);
    }

    @Override
    public String toString() {
        return "Reader " + getName() + " has lended " + books;
    }
}
