package com.thekim12.main.web.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thekim12.main.config.auth.PrincipalDetails;
import com.thekim12.main.model.todolist.TodoList;
import com.thekim12.main.service.TodoListService;
import com.thekim12.main.web.dto.TodoListInsertDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TodoListApiController {
	
	private final TodoListService todoListService;
	
	@GetMapping("/api/todo")	
	public void loadTodo(Model model, @PageableDefault() Pageable pageable) {
		Page<TodoList> todoList = todoListService.getTodoList(pageable);
	}
	
	@PostMapping("/api/todoWrite")
	public void writeTodo(@RequestBody TodoListInsertDto todoListInsertDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		todoListService.insert(todoListInsertDto, principalDetails);
		 
	}
	
	@PutMapping("/api/todoUpdate/{id}")
	public void updateTodo(@PathVariable int id, @RequestBody TodoList todoList) {
		todoListService.update();
	}
	
	@DeleteMapping("/api/todoDelete/{id}")
	public void deleteTodo(@PathVariable int id) {
		todoListService.delete(id);
	}
}
