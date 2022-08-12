package com.thekim12.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoListController {

	@GetMapping({"/" , "/todo"})
	public String index() {
		return "index";
	}

}
