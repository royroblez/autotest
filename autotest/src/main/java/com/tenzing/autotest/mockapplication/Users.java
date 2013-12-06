package com.tenzing.autotest.mockapplication;

import java.util.ArrayList;
import java.util.List;

public class Users {
	public static User createValidUser() {
		User user = new User();
		user.withUserName("username").withPassword("password");
		return user;
	}

	public static User createInvalidUser() {
		User user = new User();
		user.withUserName("").withPassword("");
		return user;
	}

	public static List<User> createValidUsers() {
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 5; i++) {
			User user = new User();
			user.withUserName("username"+i).withPassword("password"+i);
			users.add(user);
		}
		return users;
	}

}
