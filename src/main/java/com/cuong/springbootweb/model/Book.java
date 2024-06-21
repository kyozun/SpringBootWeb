package com.cuong.springbootweb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
public class Book {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    @Column()
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
    private Set<BookPublisher> bookPublisher;

    public Book() {
    }

    public Book(String name, Set<BookPublisher> bookPublisher) {
        this.name = name;
        this.bookPublisher = bookPublisher;
    }

    public Set<BookPublisher> getBookPublisherSet() {
        return bookPublisher;
    }

    public void setBookPublisherSet(Set<BookPublisher> bookPublisher) {
        this.bookPublisher = bookPublisher;
    }
}
