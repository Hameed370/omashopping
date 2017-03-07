package com.niit.hiber.omashoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.hiber.omashoppingbackend.dao.UserDAO;
import com.niit.hiber.omashoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	

	private static UserDAO userDAO;
	private User user;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.hiber.omashoppingbackend");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	
	

	/*
	@Test
	public void testAddUser()
	{
		user = new User();
		//user.setId(2);
		user.setFirstname("Niyaz");
		user.setLastname("ahmed");
		user.setContact("879576848");
		user.setEmail("nyz.admed@gmail.com");
		user.setPassword("pass@123");
		user.setUsername("nyzoma");
		user.setRole("customer");
		user.setEnabled(true);
		assertEquals("Successfully added a category inside the table", true,userDAO.add(user));
	}
	*/
	
	@Test
	public void testGetUser()
	{
		user = userDAO.get(2);
		assertEquals("Successfully fetched a category from the table", "customer",user.getRole());
		
	}
	
	
	
	/*@Test
	public void testUpdateUser()
	{
		user = userDAO.get(2);
		user.setFirstname("Niyaz");
		assertEquals("Successfully updated a category from the table", true,userDAO.update(user));
		
	}
	
	
	
	@Test
	public void testDeleteUser()
	{
		user = userDAO.get(2);
		assertEquals("Successfully deleted a category from the table", true,userDAO.delete(user));
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
