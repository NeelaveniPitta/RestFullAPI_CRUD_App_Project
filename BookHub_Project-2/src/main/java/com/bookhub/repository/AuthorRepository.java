package com.bookhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookhub.model.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

}
