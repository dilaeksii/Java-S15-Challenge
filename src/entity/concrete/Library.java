package entity.concrete;

import entity.enums.Category;

import java.util.*;

public class Library {
    private final String name = "Library";
    private final Address address = new Address("İstanbul", 3434, "Kayışdağı");
    private final List<Book> books = new ArrayList<>();
    private final Set<Reader> readers = new HashSet<>();
    private Map<Reader, Set<Book>> storeData = new HashMap<>();
    private Librarian librarian;
    private final Set<Author> authors = new HashSet<>();

    public Library() {}

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public Set<Reader> getReaders() {
        return Collections.unmodifiableSet(readers);
    }

    public Set<Author> getAuthors() {
        return Collections.unmodifiableSet(authors);
    }

    public String getName() { return name; }

    public Address getAddress() { return address; }

    public Librarian getLibrarian() { return librarian; }

    public void setLibrarian(Librarian librarian) { this.librarian = librarian; }

    public void addBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("book argument cannot be null");
        if (books.contains(book))
            throw new IllegalArgumentException("This book is already added to the library");
        this.books.add(book);
    }

    public void removeBook(Book book) {
        if (book == null)
            throw new IllegalArgumentException("Book argument cannot be null");
        this.books.remove(book);
    }

    public void addReader(Reader reader) {
        if (reader == null)
            throw new IllegalArgumentException("Reader argument cannot be null");
        if (readers.contains(reader))
            throw new IllegalArgumentException("This reader is already registered to library");
        this.readers.add(reader);
    }

    public void addAuthor(Author author) {
        if (author == null)
            throw new IllegalArgumentException("Author argument cannot be null");
        if (authors.contains(author))
            throw new IllegalArgumentException("This author is already registered to library");
        this.authors.add(author);
    }

    public void removeReader(Reader reader) {
        if (reader == null)
            throw new IllegalArgumentException("Reader argument cannot be null");
        this.readers.remove(reader);
    }

    public void removeAuthor(Author author) {
        if (author == null)
            throw new IllegalArgumentException("Author argument cannot be null");
        this.authors.remove(author);
    }

    public List<Book> filterByAuthor(Author author) {
        return books.stream().filter((Book book) -> book.getAuthor().equals(author)).toList();
    }

    public List<Book> filterByCategory(Category category) {
        return books.stream().filter((Book book) -> book.getCategory().equals(category)).toList();
    }

    public void lendBook(Reader reader, Book book) {
        if (!books.contains(book))
            throw new IllegalArgumentException("This book is not on the library");
        for (Set<Book> data: storeData.values()) {
                if (data.contains(book))
                    throw new IllegalArgumentException("This book is lended by another reader.");

        }
        if (!storeData.containsKey(reader)) {
            Set<Book> lendedBooks = new HashSet<>();
            lendedBooks.add(book);
            storeData.put(reader, lendedBooks);
            reader.addBook(book);
            librarian.createBill(reader, book);
            reader.setBudget(reader.getBudget() - book.getPrice());
        } else {
            storeData.get(reader).add(book);
            reader.addBook(book);
            librarian.createBill(reader, book);
            reader.setBudget(reader.getBudget() - book.getPrice());
        }
    }

    public void takeBook(Reader reader, Book book) {
        Set<Book> returnBook = storeData.get(reader);
        returnBook.remove(book);
        reader.removeBook(book);
        reader.setBudget(reader.getBudget() + book.getPrice());
    }
}
