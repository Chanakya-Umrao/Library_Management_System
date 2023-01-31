package com.chanakya.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanakya.springboot.entity.Book;
import com.chanakya.springboot.exceptions.ResourceNotFoundException;
import com.chanakya.springboot.repository.BookRepository;
import com.chanakya.springboot.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book addBook(Book book) {
		return this.bookRepository.save(book);
	}

	@Override
	public Book getBookByISBN(long isbn) {
		Optional<Book> optional = bookRepository.findById(isbn);
		Book book = null;
		if(optional.isPresent())
		{
			book = optional.get();
		}
		else
		{
			throw new ResourceNotFoundException("Book","isbn number ", isbn);
		}
		
		return book;
	}

	@Override
	public void deleteBookByISBN(long isbn) {
		Book book = this.bookRepository.findById(isbn).orElseThrow(() -> new ResourceNotFoundException("Book","isbn number ", isbn));
		this.bookRepository.delete(book);
	}

	@Override
	public Book updateBook(long isbn, Book book) {
		Book existingBook = bookRepository.findById(isbn).orElseThrow(() -> new ResourceNotFoundException("Book","isbn number ", isbn));

	    existingBook.setTitle(book.getTitle());
	    existingBook.setAuthor(book.getAuthor());

	    Book updatedBook = bookRepository.save(existingBook);
		return updatedBook;
	}

	
}
