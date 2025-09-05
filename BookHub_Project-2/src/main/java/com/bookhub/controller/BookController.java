package com.bookhub.controller;

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

import com.bookhub.model.BookEntity;
import com.bookhub.service.BookService;
import com.bookhub.web.request.BookRegisterRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/reg-book")
	public ResponseEntity<String> registerBook(@Valid @RequestBody(required = true) BookRegisterRequest bookRegisterRequest) {

		String response = bookService.addBook(bookRegisterRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}
	
	@GetMapping("/all")
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
	
	@PutMapping("/update/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id,@Valid @RequestBody BookRegisterRequest bookRequest) {
        return ResponseEntity.ok(bookService.updateBook(id, bookRequest));
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

}
