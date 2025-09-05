package com.bookhub.service;

import com.bookhub.web.request.AuthorRegisterRequest;

public interface IAuthorService {

	String addAuthor(AuthorRegisterRequest authorRegisterRequest);
}
