package com.example.books.models.entityModels;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "author")
    private List<BookEntity> books = new LinkedList<>();

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public Author setBooks(List<BookEntity> books) {
        this.books = books;
        return this;
    }

    public Author addBook(BookEntity book) {
        this.books.add(book);
        return this;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}
