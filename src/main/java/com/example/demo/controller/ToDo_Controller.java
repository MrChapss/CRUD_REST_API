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
	// modify the delete by adding the view title method
	@DeleteMapping("/{id}")
	public String removeTodo(@PathVariable int id) throws Exception {
		
		return "TDL: " + ViewTodo(id) + ", #" +userDao.deleteTDL(id) + " - deleted!";
	}
	// View all the todo's in JSON form
	@GetMapping
	public List<TDL> ViewTodos() throws Exception{
		return userDao.viewAllTDL();
	}
	// View a todo based on its id
	@GetMapping("/{id}")
	public String ViewTodo(@PathVariable int id) throws Exception{
		return userDao.viewTitle(id);
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
