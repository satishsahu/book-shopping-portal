package com.abc.portal.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.portal.book.dto.ReceiptDTO;
import com.abc.portal.book.entity.Book;
import com.abc.portal.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/all")
	public ResponseEntity<List<Book>> getBookDetails() {
		return new ResponseEntity<List<Book>>(bookService.getBookDetails(), HttpStatus.OK);
	}

	@PostMapping("/save/all")
	public ResponseEntity<List<Book>> saveBooks(@RequestBody List<Book> books) {
		return new ResponseEntity<List<Book>>(bookService.saveAllBooks(books), HttpStatus.CREATED);
	}

	@PostMapping("/save/single")
	public ResponseEntity<Book> saveSingleBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(bookService.saveSingleBook(book), HttpStatus.CREATED);
	}
	
	@PostMapping("/purchase")
	public ResponseEntity<ReceiptDTO> purchase(@RequestBody List<Long> bookIds) {
		return new ResponseEntity<ReceiptDTO>(bookService.purchase(bookIds), HttpStatus.OK);
	}
}
