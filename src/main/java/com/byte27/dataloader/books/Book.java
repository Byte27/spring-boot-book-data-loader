package com.byte27.dataloader.books;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "books")
public class Book {
    @Id
    private final Long id;
    private final String title;

    public Book(String title) {
        this.id = null;
        this.title = title;
    }

    @PersistenceCreator
    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
