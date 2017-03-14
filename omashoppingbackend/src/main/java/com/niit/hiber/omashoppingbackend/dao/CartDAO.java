package com.niit.hiber.omashoppingbackend.dao;

import java.util.List;
import com.niit.hiber.omashoppingbackend.dto.*;

public interface CartDAO {
	Cart get(int id);
	List<Cart> list();
	boolean add(Cart cart);
	boolean update(Cart cart);
	boolean delete(int id);	
	public Cart getCartByUserId(int userId); 
	//getcartBy
	
}
