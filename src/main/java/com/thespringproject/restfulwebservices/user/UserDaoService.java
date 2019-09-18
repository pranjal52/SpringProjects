package com.thespringproject.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
	public User save( User user) throws Exception {
		
		
		
		if(user.getId()!=null) {
			for (User existingUser :users) {
				if (existingUser.getId() == user.getId())
					throw new Exception ("Found duplicate User with same user id.");
			}
			
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
	
	/*
	 * Deletes a particular user.
	 */
	public User deleteById(Integer id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}
	
}
