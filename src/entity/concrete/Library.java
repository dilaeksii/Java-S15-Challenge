package entity.concrete;

import java.util.*;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final Set<Reader> readers = new HashSet<>();

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public Set<Reader> getReaders() {
        return Collections.unmodifiableSet(readers);
    }



}
