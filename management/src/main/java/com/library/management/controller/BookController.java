package com.library.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.model.Book;
import com.library.management.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	// Register a new book
	@PostMapping
	public ResponseEntity<Book> registerBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
	}

	// Get all books
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<>((List<Book>) 
				bookService.getAllBooks(), HttpStatus.OK);
	}

	// Borrow a book by id (for simplicity, logic can be expanded)
	@PostMapping("/{bookId}/borrow")
	public ResponseEntity<String> borrowBook(@PathVariable Long bookId) {
		// Implement borrow logic as needed

		return new ResponseEntity<>(bookService.borrowBook(bookId), 
				HttpStatus.OK);
	}

	// Return a borrowed book by id (for simplicity, logic can be expanded)
	@PostMapping("/{bookId}/return")
	public ResponseEntity<String> returnBook(@PathVariable Long bookId) {
		// Implement return logic as needed
		return new ResponseEntity<>(bookService.returnBook(bookId), 
				HttpStatus.OK);
	}
}