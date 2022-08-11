package com.thekim12.main.web.dto;

import com.thekim12.main.model.user.User;

import lombok.Data;

@Data
public class JoinDto {
	
	private String username;
	private String password;
	private String email;
	private String name;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
	}

}
