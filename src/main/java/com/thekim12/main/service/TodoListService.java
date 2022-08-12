package com.thekim12.main.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thekim12.main.config.auth.PrincipalDetails;
import com.thekim12.main.model.todolist.IsDone;
import com.thekim12.main.model.todolist.TodoList;
import com.thekim12.main.model.todolist.TodoListRepository;
import com.thekim12.main.web.dto.TodoListInsertDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoListService {
	
	private final TodoListRepository todoListRepository;
	
	@Transactional
	public void insert(TodoListInsertDto todoListDto, PrincipalDetails principalDetails) {
		TodoList todoList = 
				todoListDto.toEntity(todoListDto.getTodoList(), 
				todoListDto.getDoDate(), 
				principalDetails.getUser());
		todoList.setIsDone(IsDone.NOTYET);
		
		todoListRepository.save(todoList);
	}
	
	@Transactional
	public void delete(int id) {
		todoListRepository.deleteById(id);
	}
	
	@Transactional
	public void update() {
		
	}
	
	@Transactional
	public Page<TodoList> getTodoList(Pageable pageable){
		Page<TodoList> todolists = todoListRepository.findAll(pageable);
		return todolists;
	}
	
}
