package com.niit.hiber.omashoppingbackend.dao;

import java.util.List;

import com.niit.hiber.omashoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category>  list();
	Category get(int id);
	boolean add(Category category);
	boolean update(Category category);
	void delete(int id);

	
}
