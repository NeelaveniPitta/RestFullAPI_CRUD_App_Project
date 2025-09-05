package com.bookhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookhub.mapper.BookMapper;
import com.bookhub.model.AuthorEntity;
import com.bookhub.model.BookEntity;
import com.bookhub.repository.AuthorRepository;
import com.bookhub.repository.BookRepository;
import com.bookhub.web.request.BookRegisterRequest;

@Service
public class BookService implements IBookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookMapper mapper;
	
	@Override
	public String addBook(BookRegisterRequest bookRegisterRequest) {
		
		//DTO to Entity
		//1.ModelMapper -> 2.BeanUtils -> 3.MapStruct -> 4.getter and Setter of Entity 
		
	 /* BookEntity entity =  new BookEntity();
	  entity.setAuthor(bookRegisterRequest.getAuthor());
	  entity.setIsbn(bookRegisterRequest.getIsbn());
	  entity.setPrice(bookRegisterRequest.getPrice());
	  entity.setPublicationDate(bookRegisterRequest.getPublicationDate());
	  entity.setTitle(bookRegisterRequest.getTitle()); */
		
		//id -> auther 
		AuthorEntity authorEntity = authorRepository.findById(bookRegisterRequest.getAuthorId()).orElseThrow(() -> new RuntimeException("Author not found"));
	  
		BookEntity entity = mapper.toEntity(bookRegisterRequest);
		entity.setAuthor(authorEntity);
		
		BookEntity bookEntity = bookRepository.save(entity);
		
		return "Book Added Successfully with id "+bookEntity.getId();
	}

	public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }
	
	public BookEntity getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }
	
	public String updateBook(Long id, BookRegisterRequest request) {
        BookEntity existing = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));

        AuthorEntity authorEntity = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        existing.setTitle(request.getTitle());
        existing.setIsbn(request.getIsbn());
        existing.setPrice(request.getPrice());
        existing.setPubliLocalDate(request.getPublicationDate());
        existing.setAuthor(authorEntity);

        bookRepository.save(existing);
        return "Book updated with id " + id;
    }
	
	public String deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id " + id);
        }
        bookRepository.deleteById(id);
        return "Book deleted with id " + id;
    }
	
}
