package com.bookhub.web.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorRegisterRequest {

	@NotBlank
    private String name;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank 
	private String address;
	
}
