package com.chanakya.springboot.service;

import java.util.List;
import java.util.Optional;

import com.chanakya.springboot.entity.Book;

public interface BookService {
	
	List<Book> getAllBooks();
	Book addBook(Book book);
	Book getBookByISBN(long isbn);
	Book updateBook(long isbn,Book book);
	void deleteBookByISBN(long isbn);

}
