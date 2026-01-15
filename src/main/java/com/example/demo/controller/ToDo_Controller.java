package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/todos")
public class ToDo_Controller {
	
	private ArrayList<String> todos = new ArrayList<String>();
	
	@PostMapping("/add")
	public String addTodo(@RequestBody String todo) {
		todos.add(todo);
		
		return "Todo added: " + todo;
	}
	
	@PostMapping("/remove")
	public String removeTodo(@RequestBody String todo) {
		todos.remove(todo);
		
		return "Tod removed: " + todo;
	}
}
