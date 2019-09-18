package com.thespringproject.restfulwebservices.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sun.print.resources.serviceui;

@RestController
public class UserController {
	
	
	@Autowired
	private UserDaoService userDaoService; 
	
	@GetMapping ("/users")
	public List<User> retrieveAllUsers () {
		return userDaoService.findAll();
	}
	
	@GetMapping ("/users/{id}")
	public User retrieveUser (@PathVariable Integer id) {
		
		User user = userDaoService.findUser(id);
		
		if (user==null)
			throw new UserNotFoundException("id: "+id);
		
		return user;
	}
	
	@PostMapping("/users")
	public void createUser (@Valid @RequestBody User user) throws Exception {
		
		User savedUser = userDaoService.save(user);
		
	}
	
	@DeleteMapping ("/users/{id}")
	public void deleteUser (@PathVariable Integer id) {
		
		User user = userDaoService.deleteById(id);
		
		if (user==null)
			throw new UserNotFoundException("id: "+id);
		
	}

	

}
