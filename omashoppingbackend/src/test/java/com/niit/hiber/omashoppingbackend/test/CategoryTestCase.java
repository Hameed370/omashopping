package com.niit.hiber.omashoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.hiber.omashoppingbackend.dao.CategoryDAO;
import com.niit.hiber.omashoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.hiber.omashoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	/*
	@Test
	public void testAddCategory()
	{
		category = new Category();
		category.setName("DEFENDER");
		category.setDescription("this is a defender case for mobile.");
		category.setImageUrl("CAT_1.png");
		assertEquals("Successfully added a category inside the table", true,categoryDAO.add(category));
	}
	
	*/
	
	/* to get category
	@Test
	public void testGetCategory()
	{
		category = categoryDAO.get(2);
		assertEquals("Successfully fetched a category from the table", "TPU",category.getName());
		
	}
	*/
	

	/*//to update category
	@Test
	public void testUpdateCategory()
	{
		category = categoryDAO.get(2);
		category.setName("TPU Cases");
		assertEquals("Successfully updated a category from the table", true,categoryDAO.update(category));
		
	}
	*/
	/*
	@Test
	public void testDeleteCategory()
	{
		category = categoryDAO.get(3);
		assertEquals("Successfully deleted a category from the table", true,categoryDAO.delete(category));
		
	}*/
	/*
	
	@Test
	public void testGetListCategory()
	{
		assertEquals("Successfully fetched all categories from the table", 2,categoryDAO.list().size());
		
	}
	*/
}
