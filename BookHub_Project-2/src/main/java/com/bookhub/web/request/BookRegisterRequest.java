package com.bookhub.web.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRegisterRequest {

    @NotBlank
    private String title;

    private LocalDate publicationDate;

    @NotBlank
    private String isbn;

    @NotNull
    private Double price;

    @NotNull
    private Long authorId;
}

