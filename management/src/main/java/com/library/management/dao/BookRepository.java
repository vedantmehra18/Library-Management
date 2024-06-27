package com.library.management.dao;

import org.springframework.data.repository.CrudRepository;

import com.library.management.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
