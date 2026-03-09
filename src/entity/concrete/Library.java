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

    /*Yazılacak metotlar
    * 1)addBok
    * 2)addReader
    * 3)removeReader
    * 4)removeBook
    * 5)showBook*/


}
