package com.bookhub.service;

import com.bookhub.web.request.BookRegisterRequest;

public interface IBookService {

	String addBook(BookRegisterRequest bookRegisterRequest);
}
