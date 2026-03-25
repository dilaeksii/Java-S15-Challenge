package entity.concrete;

import java.util.List;
import java.util.Objects;

public class Librarian {
    private Long librarianId;
    private String name;
    private String password;
    private Library library;

    public Librarian() {}

    public Long getLibrarianId() { return librarianId; }

    public String getName() { return name; }

    public Library getLibrary() { return library; }

    public String getPassword() { return password; }

    private void setLibrarianId(Long librarianId) { this.librarianId = librarianId; }

    public void setLibrary(Library library) { this.library = library; }

    public void setName(String name) {
        this.name = name;
    }

    private void setPassword(String password) { this.password = password; }

    public String searchBook(String name) {
        for (Book book: library.getBooks()) {
            if (book.getName().equals(name)) {
                return "The book " + book.getName() + " has been found.";
            }
        }
        return "Searched book is not in the library";
    }

    public Double calculateBill(Book book) {
        return book.getPrice();
    }

    public String createBill(Reader reader, Book book) {
        Double price = calculateBill(book);
        if (price == null)
            throw new IllegalArgumentException("Price cannot be null");
        reader.setBudget(reader.getBudget() - price);
        return "Reader " + reader.getName() +
                " should pay: " + price +
                " for book: " + book.getName();
    }

    public boolean verifyMember(Reader reader) {
        return library.getReaders().contains(reader) && reader.getMember() != null;
    }


    @Override
    public String toString() {
        return "The librarians name is: " + getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass())  return false;
        Librarian librarian = (Librarian) obj;
        return librarian.librarianId.equals(librarianId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(librarianId);
    }
}
