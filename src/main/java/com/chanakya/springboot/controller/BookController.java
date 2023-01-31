package com.chanakya.springboot.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chanakya.springboot.entity.Book;

import com.chanakya.springboot.service.BookService;
import com.chanakya.springboot.util.ApiResponse;


@RestController
@RequestMapping("/api/books")
public class BookController {
	
  @Autowired
  private BookService bookService;

  //Retrieve a list of all books in the library
  @GetMapping
 // @ApiOperation(value = "Get all Books")
  public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> books = bookService.getAllBooks();
    return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
  }

  //Add a new book to the library
  @PostMapping
 // @ApiOperation(value = "Add a new Book")
  public ResponseEntity<Book> addBook(@RequestBody Book book) {
    Book newbook =  bookService.addBook(book);
    return new ResponseEntity<Book>(newbook, HttpStatus.CREATED);
  }

  //Retrieve a book by its ISBN number
  @GetMapping("/{id}")
  //@ApiOperation(value = "Get a book by its isbn number")
  public ResponseEntity<Book> getBook(@PathVariable long id)
  {
	  Book book = bookService.getBookByISBN(id);
	  return new ResponseEntity<Book>(book,HttpStatus.OK);
  }
  
  //Update the information for a book
  @PutMapping("/{id}")
 // @ApiOperation(value = "Update a book")
  public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book) {
	  Book updatedBook = bookService.updateBook(id, book);
	  return new ResponseEntity<Book>(updatedBook,HttpStatus.OK);
  }

  //Delete a book from the library
  @DeleteMapping("/{id}")
  //@ApiOperation(value = "Delete a book")
  public ResponseEntity<ApiResponse> deleteBook(@PathVariable long id) {
	  bookService.deleteBookByISBN(id);
	  return new ResponseEntity<ApiResponse>(new ApiResponse("Book is deleted successfully !!", true), HttpStatus.OK);
  }
}

