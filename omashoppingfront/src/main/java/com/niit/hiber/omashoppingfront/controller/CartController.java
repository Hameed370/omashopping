package com.niit.hiber.omashoppingfront.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.hiber.omashoppingbackend.dao.CartDAO;
import com.niit.hiber.omashoppingbackend.dao.CartItemDAO;
import com.niit.hiber.omashoppingbackend.dao.ProductDAO;
import com.niit.hiber.omashoppingbackend.dao.UserDAO;
import com.niit.hiber.omashoppingbackend.dto.Product;
import com.niit.hiber.omashoppingbackend.dto.*;

@Controller
@RequestMapping("/customer")
public class CartController {
	
	
	@Autowired
	private CartItemDAO cartItemDAO;
	@Autowired
	private ProductDAO productDAO;
	
	
	@Autowired
	private CartDAO cartDAO;
	

	@Autowired
	private UserDAO userDAO;

	//@Autowired
	private User user;
	
	
	
	@RequestMapping(value="/cart")
	public String viewcart(Principal principal, Model mv) 
	{
		

		if (principal != null) 
		{
			user = userDAO.getUserByUserName(principal.getName());

			if (user.getRole().equals("admin"))
				return "redirect:/admin";

		}

		Cart cart =user.getCart(); 
		//cart.getUser();
		mv.addAttribute("title", "Customer - View Cart");
		//mv.addAttribute("cartitem",cartItemDAO.list(cart));
		mv.addAttribute("cart", cart);
		mv.addAttribute("productlist", productDAO.list());
		mv.addAttribute("cartitemlist", cartItemDAO.list(cart));
		mv.addAttribute("userClickViewCart", true);
		return "page";
	}
	
	
	@RequestMapping(value="/cart/checkout")
	public   ModelAndView checkoutt()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","CHeckOUT");
		mv.addObject("userClickCheckout", true);
		return mv;
	}
	
	
	
	@RequestMapping(value="/cart/addtocart/{id}")
	public String addtocart(@PathVariable("id") int id, Principal principal, Model mv) 
	{
		
		if (principal != null) 
		{
			user = userDAO.getUserByUserName(principal.getName());

			if (user.getRole().equals("admin"))
				return "redirect:/admin";
		}
		/*Product product = null;	
		//Cart cart = new Cart();
		//cart.setId(user.getId());
		//cart.setUser(user);
		product = productDAO.get(id);
		CartItem cartItem = new CartItem();
		//cartItem.setId();		cartItem.setCart(user.getCart());
		cartItem.setQuantity(cartItem.getQuantity()+1);
		cartItem.setProduct(product);
		cartItem.setTotalPrice(product.getPrice()*cartItem.getQuantity());
		//cartItem.setCart(cart);
		cartItemDAO.add(cartItem);
		
		mv.addAttribute("cartitem",cartItem);
		mv.addAttribute("userClickCart", true);*/
		
		// get the user
				//User user = userDAO.get();
				// get the cart
				Cart cart = user.getCart();
		System.out.println(cart.getId() + " " + cart.getUser());
				// get the product
				Product product = productDAO.get(id);
				
				CartItem cartItem = new CartItem();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				cartItem.setQuantity(1);
				cartItem.setTotalPrice(product.getPrice() * cartItem.getQuantity());
				cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotalPrice());
				cart.setCartItemsCount(cart.getCartItemsCount() + 1);
				cartItemDAO.add(cartItem);
		
		
		return "redirect:/customer/cart";
	}
	
	
	

}
