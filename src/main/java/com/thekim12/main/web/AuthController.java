package com.thekim12.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.thekim12.main.model.user.User;
import com.thekim12.main.service.AuthService;
import com.thekim12.main.web.dto.JoinDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	
	@GetMapping("/auth/login")
	public String loginForm() {
		return "auth/login";
	}
	
	@GetMapping("/auth/join")
	public String joinForm() {
		return "auth/join";
	}

	@PostMapping("/auth/join")
	public String join(JoinDto joinDto) {
		User user = joinDto.toEntity();
		authService.join(user);
		return "auth/login";
	}
}
