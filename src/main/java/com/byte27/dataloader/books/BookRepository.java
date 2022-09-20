package com.byte27.dataloader.books;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    boolean existsByTitle(String title);
}
