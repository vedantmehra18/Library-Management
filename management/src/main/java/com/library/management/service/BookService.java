package com.library.management.service;

import java.util.List;

import com.library.management.model.Book;

public interface BookService {
	
	public Book save(Book book);
	
	public List<Book>getAllBooks();

    public String borrowBook(Long bookId);

    public String returnBook(Long bookId);

}
