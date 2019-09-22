package com.thespringproject.restfulwebservices.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.thespringproject.restfulwebservices.user.User;
import com.thespringproject.restfulwebservices.user.UserDaoService;

import sun.print.resources.serviceui;

@RestController
public class UserController {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}

	@GetMapping("/users/ids")
	public MappingJacksonValue retrieveAllUserIds() {

		List<User> listOfUnfilteredUsers = userDaoService.findAll();
		

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id");
		FilterProvider filters = new SimpleFilterProvider().addFilter("ID_FILTER", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(listOfUnfilteredUsers);

		mapping.setFilters(filters);

		return mapping;

	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable Integer id) {

		User user = userDaoService.findUser(id);

		// Resource<User> resource<User>(user);
		if (user == null)
			throw new UserNotFoundException("id: " + id);

		return user;
	}

	@PostMapping("/users")
	public void createUser(@Valid @RequestBody User user) throws Exception {

		User savedUser = userDaoService.save(user);

	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Integer id) {

		User user = userDaoService.deleteById(id);

		if (user == null)
			throw new UserNotFoundException("id: " + id);

	}

}
