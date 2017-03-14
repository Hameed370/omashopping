package com.niit.hiber.omashoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.hiber.omashoppingbackend.dao.CartItemDAO;
import com.niit.hiber.omashoppingbackend.dao.ProductDAO;
import com.niit.hiber.omashoppingbackend.dao.*;
import com.niit.hiber.omashoppingbackend.dto.Cart;
import com.niit.hiber.omashoppingbackend.dto.CartItem;
import com.niit.hiber.omashoppingbackend.dto.*;



public class CartItemTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CartItemDAO cartItemDAO;

	private static UserDAO userDAO;

	private static ProductDAO productDAO;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.hiber.omashoppingbackend");
		context.refresh();
		cartItemDAO = (CartItemDAO)context.getBean("cartItemDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");

	}
/*
	
	@Test
	public void testListCartItem(){
		
		// get the user
		User user = userDAO.get(2);
		// get the cart
		Cart cart = user.getCart();
		// get the cartItems
		
		//System.out.println(cartItemDAO.list(cart));
		assertEquals("List CartItem fetched Successfully!",3,cartItemDAO.list(cart).size());
		
	}
*/
	// Adding a new cartItem
	/*
@Test
	public void testAddCartItem() {
		
		// get the user
		User user = userDAO.get(2);
		// get the cart
		Cart cart = user.getCart();
System.out.println(cart.getId() + " " + cart.getUser());
		// get the product
		Product product = productDAO.get(1);
		
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
		cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotalPrice());
		cart.setCartItemsCount(cart.getCartItemsCount() + 1);
		assertEquals("Successfully added the cart item!",true, cartItemDAO.add(cartItem));
		
		
	}
*/
/*
	// updating the existing cart item
	@Test
	public void testUpdateCartItem() {
				
		CartItem cartItem = cartItemDAO.get(2);
		System.out.println(cartItem.toString());
		
		Cart cart = cartItem.getCart();
		
		Product product = cartItem.getProduct();
		
		int oldQuantity = cartItem.getQuantity();

		cartItem.setQuantity(cartItem.getQuantity() + 1);
		
		cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartItem.getQuantity() - oldQuantity) * product.getPrice());
		
		assertEquals("Successfully updated the cart item!",true, cartItemDAO.update(cartItem));

		//assertEquals("Successfully updated the cart item!",true, cartItemDAO.updateCart(cart));

		
	}
	
	*/
}
