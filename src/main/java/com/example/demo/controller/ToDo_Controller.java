package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/todos")
public class ToDo_Controller {
	
	private ArrayList<String> todos = new ArrayList<String>();
	
	@PostMapping
	public String addTodo(@RequestBody String todo) {
		todos.add(todo);
		
		return "Todo added: " + todo;
	}
	
	@DeleteMapping
	public String removeTodo(@RequestBody String todo) {
		todos.remove(todo);
		
		return "Todo removed: " + todo;
	}
	
	@GetMapping
	public String showTodo(@RequestParam (required = false, defaultValue = "Skibidi") String todo) {
		for (int i=0; i<todos.size(); i++) {
			todos.get(i);
		}
		return "Todo are: " + todos;
	}
	
	@PutMapping
	public String updataTodo(@RequestBody String todo) {
		return "Sigma";
	}
	
}
