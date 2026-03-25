package entity.concrete;

import entity.AbstractPerson;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Author extends AbstractPerson {
    private final Set<Book> books = new HashSet<>();

    public Author(Long id, String name) {
        super(id, name);
    }

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

    public void removeBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("Book argument cannot be null");
        this.books.remove(book);
    }

    public void showBooks() {
        Iterator<Book> i = books.iterator();
        System.out.println(this.getName() + " has written:");
        while (i.hasNext()) {
            Book book = i.next();
            System.out.println(book.getName());
        }
    }

    @Override
    public void whoYouAre() {
        System.out.println("I'm an author");
    }

}
