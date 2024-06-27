package com.library.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.management.dao.BookRepository;
import com.library.management.model.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	// Method to register a new book
	public Book registerBook(Book book) {
		// Implement validation and business logic as needed
		return bookRepository.save(book);
	}

	// Method to retrieve all books
	public List<Book> getAllBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	// Method to find a book by ID
	public Optional<Book> findBookById(Long id) {
		return bookRepository.findById(id);
	}

	// Method to delete a book by ID
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	// Method to update a book
	public Book updateBook(Long id, Book updatedBook) {
		// Check if the book exists
		Optional<Book> existingBookOptional = bookRepository.findById(id);
		if (existingBookOptional.isPresent()) {
			Book existingBook = existingBookOptional.get();
			// Update fields of existingBook with fields from updatedBook
			existingBook.setIsbn(updatedBook.getIsbn());
			existingBook.setTitle(updatedBook.getTitle());
			existingBook.setAuthor(updatedBook.getAuthor());
			return bookRepository.save(existingBook);
		} else {
			throw new RuntimeException("Book not found with id: " + id);
		}
	}

	// Method to borrow a book (sample method, adjust as per your logic)
	@Override
	public String borrowBook(Long bookId) {
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		if (bookOptional.isPresent()) {
			Book book = bookOptional.get();
			// Implement borrow logic here
			book.setAvailable(false); // Example: Mark the book as unavailable
			bookRepository.save(book);
			return "Book Borrowed";
		} else {
			throw new RuntimeException("Book not found with id: " + bookId);
		}
	}

	// Method to return a borrowed book (sample method, adjust as per your logic)
	@Override
	public String returnBook(Long bookId) {
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		if (bookOptional.isPresent()) {
			Book book = bookOptional.get();
			// Implement return logic here
			book.setAvailable(true); // Example: Mark the book as available
			bookRepository.save(book);
			return "Book Retuned";
		} else {
			throw new RuntimeException("Book not found with id: " + bookId);
		}
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	// Other methods as needed

}
