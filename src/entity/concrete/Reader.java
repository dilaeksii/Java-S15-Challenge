package entity.concrete;

import entity.AbstractPerson;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Reader extends AbstractPerson {
    private Member member;
    private final Set<Book> books = new HashSet<>();
    private Double budget;

    public Reader(Long id, String name, Member member) {
        super(id, name);
        this.setMember(member);
    }

    public Reader(Long id, String name, Address address, String phoneNumber, String email, Member member, Double budget) {
        super(id, name, address, phoneNumber, email);
        this.setMember(member);
        this.setBudget(budget);
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }

    public Member getMember() { return member; }

    public Double getBudget() { return budget; }

    public void setMember(Member member) { this.member = member; }

    public void setBudget(Double budget) { this.budget = budget;}

    public void addBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("Book argument cannot be null");
        if (books.size() >= 5)
            throw new IllegalStateException("Reader cannot lend more than five books");
        if (books.contains(book))
            throw new IllegalArgumentException("This book lended by reader before.");
        this.books.add(book);
    }

    public void removeBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("Book argument cannot be null");
        this.books.remove(book);
    }

    @Override
    public void whoYouAre() {
        System.out.println("I'm reader " + getName());
    }

    @Override
    public String toString() {
        return "Reader " + getName() + " has lended " + books;
    }
}
