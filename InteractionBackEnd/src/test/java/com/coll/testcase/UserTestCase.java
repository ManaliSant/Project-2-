package com.coll.testcase;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.UserDao;
import com.coll.models.UserDetail;

public class UserTestCase {

	@Autowired
	static UserDao userDao;

	@BeforeClass
	public static void setUp() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();

		userDao = (UserDao) context.getBean("userDao");
	}

	@Test
	public void registerUserTest(){
		UserDetail user = new UserDetail();

		user.setLoginname("Manali");
		user.setPassword("pass123");
		user.setUsername("Manali Sant");
		user.setEmailid("manali@gmail.com");
		user.setMobileno("9845128765");
		user.setAddress("Kolhapur");
		user.setRole("ROLE_USER");
	
		assertTrue("Problem in Registering the User:",userDao.registerUser(user));
	
	}

}
