package com.library.management.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.library.management.dao.BookRepository;
import com.library.management.model.Book;
import com.library.management.service.BookService;

	public class BookServiceTest {

	    @Mock
	    private BookRepository bookRepository;

	    @InjectMocks
	    private BookService bookService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testRegisterBook() {
	        Book book = new Book();
	        book.setIsbn("1234567890");
	        book.setTitle("Example Book");
	        book.setAuthor("Jane Doe");
	        when(bookRepository.save(any(Book.class))).thenReturn(book);
	        Book savedBook = bookService.save(book);
	        assertEquals("1234567890", savedBook.getIsbn());
	        assertEquals("Example Book", savedBook.getTitle());
	        assertEquals("Jane Doe", savedBook.getAuthor());
	    }
	}