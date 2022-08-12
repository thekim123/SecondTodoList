package com.thekim12.main.web.dto;

import java.util.Date;

import com.thekim12.main.model.todolist.TodoList;
import com.thekim12.main.model.user.User;

import lombok.Data;

@Data
public class TodoListInsertDto {

	private String todoList;
	private Date doDate;
	
	public TodoList toEntity(String todoList, Date doDate, User user) {
		return TodoList.builder()
				.todoList(todoList)
				.doDate(doDate)
				.user(user)
				.build();
				
	}

}
