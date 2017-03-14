package com.niit.hiber.omashoppingbackend.dao;

import java.util.List;
import com.niit.hiber.omashoppingbackend.dto.*;


public interface CartItemDAO {

	CartItem get(int id);
	List<CartItem> list(Cart cart);
	boolean add(CartItem cartItem);
	boolean update(CartItem cartItem);
	boolean delete(int id);	
	public CartItem getCartByUserId(int userId); 

	
}
