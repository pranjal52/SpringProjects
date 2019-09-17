package com.thespringproject.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sun.print.resources.serviceui;

@RestController
public class UserResource {
	
	
	@Autowired
	private UserDaoService userDaoService; 
	
	@GetMapping ("/users")
	public List<User> retrieveAllUsers () {
		return userDaoService.findAll();
	}
	
	@GetMapping ("/users/{id}")
	public User retrieveUser (@PathVariable Integer id) {
		return userDaoService.findUser(id);
	}
	
	@PostMapping("/users")
	public void createUser (@RequestBody User user) {
		
		User savedUser = userDaoService.save(user);
		
	}

	

}
