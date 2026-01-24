package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dao.UserDao;

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
						  @RequestParam (required = false) Boolean is_completed) throws Exception {
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
	@GetMapping
	public String getTodos(int id) throws Exception{
		 userDao.viewTDL(id);
		 return "User: " + id;
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
