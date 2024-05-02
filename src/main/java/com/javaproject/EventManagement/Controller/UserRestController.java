package com.javaproject.EventManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.EventManagement.entities.User;
import com.javaproject.EventManagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	private UserService userService;
	
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}

	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {
		
		User theUser = userService.findById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		return theUser;
	}
	
	
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {
				
		return userService.save(theUser);
	}
	
	
	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User theUser,@PathVariable int id) {
		
		userService.updateUser(theUser,id);
		
		return theUser;
	}
	
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		
		User tempUser = userService.findById(userId);
		
		// throw exception if null
		
		if (tempUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		userService.deleteById(userId);
		
		return "Deleted user id - " + userId;
	}
	
}
