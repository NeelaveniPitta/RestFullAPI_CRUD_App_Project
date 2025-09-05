package com.bookhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookhub.model.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
