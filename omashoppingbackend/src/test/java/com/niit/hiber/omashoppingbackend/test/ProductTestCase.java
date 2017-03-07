package com.niit.hiber.omashoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.hiber.omashoppingbackend.dao.ProductDAO;
import com.niit.hiber.omashoppingbackend.dto.Product;

public class ProductTestCase {
	
	

	private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO productDAO;
	private Product product; 
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.hiber.omashoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	
	
	@Test
	public void testAddProduct()
	{
		product = new Product();
		product.setId(8);
		product.setPname("Sandisk MMC");
		product.setDescription("Sandisk memory card for all type of devices.");
		product.setPrice(350);
		product.setQty(40);
		product.setActive(true);
		assertEquals("Successfully added a category inside the table", true,productDAO.add(product));
	}
	
	
	
	/* to get category
	@Test
	public void testGetProduct()
	{
		category = categoryDAO.get(2);
		assertEquals("Successfully fetched a category from the table", "TPU",category.getName());
		
	}
	*/
	

	/*//to update category
	@Test
	public void testUpdateProduct()
	{
		category = categoryDAO.get(2);
		category.setName("TPU Cases");
		assertEquals("Successfully updated a category from the table", true,categoryDAO.update(category));
		
	}
	*/
	
	/*@Test
	public void testDeleteProduct()
	{
		category = categoryDAO.get(2);
		assertEquals("Successfully deleted a category from the table", true,categoryDAO.delete(category));
		
	}*/
	
/*	
	@Test
	public void testGetListproduct()
	{
		assertEquals("Successfully fetched all categories from the table", 2,productDAO.list().size());
		
	}
*/
	

}
