package com.niit.hiber.omashoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.hiber.omashoppingbackend.dao.CartDAO;
import com.niit.hiber.omashoppingbackend.dao.UserDAO;
import com.niit.hiber.omashoppingbackend.dto.Cart;
import com.niit.hiber.omashoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	//@Autowired
	private static CartDAO cartDAO;
	
	private static UserDAO userDAO;
	private User user;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.hiber.omashoppingbackend");
		context.refresh();
		userDAO = (UserDAO)context.getBean("userDAO");
		cartDAO = (CartDAO)context.getBean("cartDAO");
	}
	
	
	

	/*
	@Test
	public void testAddUser()
	{
		user = new User();
		//user.setId(2);
		user.setFirstName("chirag");
		user.setLastName("singla");
		user.setEmail("chirag@gmail.com");
		user.setEnabled(true);
		user.setPassword("pass@123");
		user.setRole("customer");
		user.setContactNumber("9878923456");
		Cart cart = new Cart();
		cart.setUser(user);
		cartDAO.add(cart);
		assertEquals("Successfully added a category inside the table", true,userDAO.add(user));
	}
	*/
	
	/*@Test
	public void testGetUser()
	{
		user = userDAO.get(2);
		assertEquals("Successfully fetched a category from the table", "customer",user.getRole());
		
	}
	*/
	
	
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
