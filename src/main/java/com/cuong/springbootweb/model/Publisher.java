package com.cuong.springbootweb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Setter
@Getter
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column()
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "publisher")
    private Set<BookPublisher> bookPublisher;

    public Publisher() {
    }

//    public Publisher(String name, Set<BookPublisher> bookPublisher) {
//        this.name = name;
//        this.bookPublisher = bookPublisher;
//    }

}
