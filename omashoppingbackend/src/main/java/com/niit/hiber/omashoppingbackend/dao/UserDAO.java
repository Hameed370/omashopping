package com.niit.hiber.omashoppingbackend.dao;

import java.util.List;

import com.niit.hiber.omashoppingbackend.dto.User;

public interface UserDAO {
	
	List<User>  list();
	User get(int id);
	boolean add(User user);
	boolean update(User user);
	boolean delete(User user);

}
