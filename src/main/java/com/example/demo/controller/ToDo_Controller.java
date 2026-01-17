package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/todos")
public class ToDo_Controller {
	
	private ArrayList<String> todos = new ArrayList<String>();
	
	@PostMapping
	public String addTodo(@RequestBody String todo) {
		for (String tdl : todos) {
			if (todo.isEmpty()) {
				return "a todo cannot be empty!";
			}
			
			if (tdl.contains(todo)) {
				return "'" + todo + "' todo already exist in the list!";
			}
		}
		todos.add(todo);
		return "Todo added: " + todo;
	}
	
	@DeleteMapping
	public String removeTodo(@RequestBody String todo) {
		if (!todos.contains(todo)) {
			return "'" + todo + "' does not exist in the list!";
		}
		todos.remove(todo);
		return "Todo removed: " + todo;
	}
	
	@GetMapping
	public String showTodo(@RequestParam (required = false, defaultValue = "Skibidi") String todo) {
		
		return "Todo are: " + todos;
	}
	
	@PutMapping
	public String updataTodo(@RequestBody String todo) {
		return todo;
	}
	
}
