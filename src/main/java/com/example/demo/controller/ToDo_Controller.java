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
	
	@DeleteMapping("/{index}")
	public String removeTodo(@PathVariable int index) {
		if (index<0||index>=todos.size()) {
			return "Invalid index: " + index;
		}
		String removedTodo = todos.remove(index);
		return "Deleted todo : '" + removedTodo + "'";
		
		/*
		if (!todos.contains(todo)) {
			return "'" + todo + "' does not exist in todo list!";
		}
		todos.remove(todo);
		return "Todo removed: " + todo;
		*/
	}
	
	@GetMapping
	public ArrayList<String> getTodos(){
		return todos;
	}
	
	@PutMapping("/{index}")
	public String updateTodo(@PathVariable int index, @RequestBody String todo) {
		if (index<0||index>=todos.size()) {
			return "Invalid";
		}
		String oldTodo = todos.set(index, todo);
		return "Updated todo: " + oldTodo + "' to '" + todo;
	}
	
}
