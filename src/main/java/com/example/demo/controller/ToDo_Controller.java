package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.*;
import java.util.*;

@RestController
@RequestMapping("/todos")
public class ToDo_Controller {
	private final UserDao userDao;
	
	public ToDo_Controller(@Qualifier("userDao") UserDao userDao) {
		this.userDao=userDao;
	}
	// Create a new todo and store in h2 databse
	@PostMapping
	public String addUser(@RequestParam String title,
						  @RequestParam String description,
						  @RequestParam (required = false, defaultValue= "FALSE") Boolean is_completed) throws Exception {
		userDao.createTDL(title, description, is_completed);
		return "Created a todo!";
	}
	// Delete a todo from h2 database through id
	@DeleteMapping("/{id}")
	public String removeTodo(@RequestParam int id) throws Exception {
		userDao.deleteTDL(id);
		return "TDL: '" + id + "' deleted!";
	}
	// i still don't fucking get it
	// will fix this later
	@GetMapping
	public List<TDL> getTodos() throws Exception{
		return userDao.viewTDL();
	}
	// Update the todo if user wants to change the title, description, and status (is_completed)
	@PutMapping("/{id}")
	public String updateTodo(@PathVariable int id,
							 @RequestParam String title,
							 @RequestParam String description,
							 @RequestParam Boolean is_completed) throws Exception{
		userDao.updateTDL( id, title, description, is_completed);
		return "TDL#" + id + " has been updated!";
	}
	
}
