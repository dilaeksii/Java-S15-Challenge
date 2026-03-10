package entity.concrete;

import entity.enums.Category;

import java.util.Objects;

public class Book {
    private Long id;
    private Author author;
    private String name;
    private Double price;
    private String edition;
    private Category category;

    public Book(Long id, Author author, String name, Double price, String edition, Category category) {
        this.setId(id);
        this.setAuthor(author);
        this.setName(name);
        this.setPrice(price);
        this.setEdition(edition);
        this.setCategory(category);
    }

    public Long getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getEdition() {
        return edition;
    }

    public Category getCategory() {
        return category;
    }

    private void setId(Long id) {
        if (id == null)
            throw new IllegalArgumentException("id argument cannot be null");
        if (id <= 0)
            throw new IllegalArgumentException("id cannot be equal or less than zero");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException("name argument cannot be null");
        if (name.isEmpty())
            throw new IllegalArgumentException("name argument cannot be empty");
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPrice(Double price) {
        if (price == null)
            throw new IllegalArgumentException("Price argument cannot be null");
        if(price <= 0)
            throw new IllegalArgumentException("Price argument cannot be less than zero.");
        this.price = price;
    }

    public void setEdition(String edition) {
        if(edition == null)
            throw new IllegalArgumentException("Edition argument cannot be null");
        this.edition = edition;
    }

    public void setCategory(Category category) {
        if (category == null)
            throw new IllegalArgumentException("Caegory argument cannot be null");
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book Name: " + name
                + " Author: " + author.getName()
                + " Category: " + category;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != getClass())
            return false;
        Book book = (Book) obj;
        return book.id.equals(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
