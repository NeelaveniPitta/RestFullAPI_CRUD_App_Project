package com.bookhub.mapper;

import org.mapstruct.Mapper;

import com.bookhub.model.BookEntity;
import com.bookhub.web.request.BookRegisterRequest;

@Mapper(componentModel = "spring")
public interface BookMapper {

	BookEntity toEntity(BookRegisterRequest dto);
}
