package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dao.UserDao;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class ToDo_Controller {
	private final UserDao userDao;
	private ArrayList<String> todos = new ArrayList<String>();
	
	public ToDo_Controller(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@PostMapping
	public String addUser(@RequestParam String name,
						  @RequestParam int age,
						  @RequestParam String underage) throws Exception {
		if(age<=17) {
			underage = "yes";
		} else {
			underage = "no";
		}
		
		userDao.CreateUser(name, age, underage);
		return "User '" + name + "' created!";
	}
	
	@DeleteMapping
	public String removeTodo(@RequestParam String name) throws Exception {
		userDao.DeleteUser(name);
		return "User '" + name + "' deleted!";
	}
	// learning how to getmap in h2 db
	@GetMapping
	public String getTodos(String name) throws Exception{
		 userDao.ViewUser(name);
		 return "User: " + name;
		 
	}
	// learning this too
	@PutMapping("/{index}")
	public String updateTodo(@PathVariable int index, @RequestBody String todo) {
		if (index<0||index>=todos.size()) {
			return "Invalid";
		}
		String oldTodo = todos.set(index, todo);
		return "Updated todo: " + oldTodo + "' to '" + todo;
	}
	
}
