package com.thespringproject.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User (1, "Abhay", new Date()));
		users.add(new User (2, "Pranjal", new Date()));
		users.add(new User (3, "Ram", new Date()));
	}
	
	private static int userCount =3;
	
	/*
	 * Returns all the users
	 */
	public List<User> findAll() {
		return users;
	}
	
	/*
	 * Adds a user
	 */
	public User save( User user) {
		
		if(user.getId()!=null) {
			users.add(user);
		} else {
			user.setId(++userCount);
			users.add(user);
		}
		
		return user;
		
	}
	
	/*
	 * Returns a particular user.
	 */
	public User findUser(Integer id) {
		
		for (User user: users) {
			if (user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
}
