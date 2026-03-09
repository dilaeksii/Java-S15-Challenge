package main;

import entity.AbstractPerson;
import entity.concrete.Address;
import entity.concrete.Author;
import entity.concrete.Book;
import entity.enums.Category;


public class Main {
    public static void main(String[] args) {
        Author author1 = new Author(1l, "Stefan Zweig", new Address("Los Angeles", 1234, "CK"), "12345678", "szweig@gmail.com");
        Author author2 = new Author(2l, "Gülseren Budayıcıoğlu", new Address("Ankara", 7675, "Anıtkabir"), "7546466464", "gülseren@gmail.com");

        Book book1 = new Book(1l, author1, "Test Kitap 1", 220.5, "16", Category.POLICY);
        Book book2 = new Book(2l, author1, "Test Kitap 2", 190.5, "3", Category.SCIENCE);
        Book book3 = new Book(3l, author1, "Test Kitap 3", 85.5, "5", Category.SELF_HELP);

        Book book4 = new Book(4l, author2, "Test Kitap 4", 220.5, "16", Category.BIOGRAPHY);
        Book book5 = new Book(5l, author2, "Test Kitap 5", 190.5, "3", Category.NON_FICTION);
        Book book6 = new Book(6l, author2, "Test Kitap 6", 85.5, "5", Category.FANTASY);

        author1.addBook(book1);
        author1.addBook(book2);
        author1.addBook(book3);
        System.out.println(author1.getBooks());
        System.out.println(author1);

        author2.addBook(book5);
        author2.addBook(book4);
        author2.addBook(book6);
        System.out.println(author2.getBooks());
        System.out.println(author2);

    }
}