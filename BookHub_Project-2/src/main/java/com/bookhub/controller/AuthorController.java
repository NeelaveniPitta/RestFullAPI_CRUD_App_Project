package com.bookhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookhub.model.AuthorEntity;
import com.bookhub.service.AuthorService;
import com.bookhub.web.request.AuthorRegisterRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService service;
	
	@PostMapping("/add-author")
	public String addAuthor(@Valid @RequestBody(required = true) AuthorRegisterRequest authorRegisterRequest) {
		
		String reponse = service.addAuthor(authorRegisterRequest);
		
		return reponse;
	}
	
	 @GetMapping("/all")
	 public ResponseEntity<List<AuthorEntity>> getAllAuthors() {
		 return ResponseEntity.ok(service.getAllAuthors());
	 }

	 @GetMapping("/{id}")
	 public ResponseEntity<AuthorEntity> getAuthorById(@PathVariable Long id) {
	     return ResponseEntity.ok(service.getAuthorById(id));
	 }

	 @PutMapping("/update/{id}")
	 public ResponseEntity<String> updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorRegisterRequest authorRequest) {
		 return ResponseEntity.ok(service.updateAuthor(id, authorRequest));
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
	     return ResponseEntity.ok(service.deleteAuthor(id));
	 }
	 
}
