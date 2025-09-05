package com.bookhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookhub.mapper.AuthorMapper;
import com.bookhub.model.AuthorEntity;
import com.bookhub.repository.AuthorRepository;
import com.bookhub.web.request.AuthorRegisterRequest;

@Service
public class AuthorService implements IAuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private AuthorMapper mapper;
	
	@Override
	public String addAuthor(AuthorRegisterRequest authorRegisterRequest) {
		
		AuthorEntity entity = authorRepository.save(mapper.toEntity(authorRegisterRequest));
		
		return "auther saved with id "+entity.getId();
	}

	public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }
	
	public AuthorEntity getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found with id " + id));
    }
	
	public String updateAuthor(Long id, AuthorRegisterRequest request) {
        AuthorEntity existing = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id " + id));

        existing.setName(request.getName());
        existing.setEmail(request.getEmail());
        // add more fields if needed

        authorRepository.save(existing);
        return "Author updated with id " + id;
    }
	
	public String deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found with id " + id);
        }
        authorRepository.deleteById(id);
        return "Author deleted with id " + id;
    }
	
}
