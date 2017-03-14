package com.niit.hiber.omashoppingbackend.dao;

import java.util.List;

import com.niit.hiber.omashoppingbackend.dto.Product;

public interface ProductDAO {

	List<Product>  list();
	List<Product> listAll();
	Product get(int id);
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
}
