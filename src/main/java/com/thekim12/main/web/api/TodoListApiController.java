package com.thekim12.main.web.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thekim12.main.service.TodoListService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TodoListApiController {
	
	private final TodoListService todoListService;
	
	@GetMapping()
	public void loadTodo() {
		
	}
	
	@PostMapping()
	public void writeTodo() {
		
	}
	
	@PutMapping
	public void updateTodo() {
		
	}
	
	@DeleteMapping
	public void deleteTodo() {
		
	}
}
