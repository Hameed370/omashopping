package com.niit.hiber.omashoppingbackend.dao;

import java.util.List;

import com.niit.hiber.omashoppingbackend.dto.Address;



public interface AddressDAO {
	Address get(int id);

	List<Address> list();

	boolean add(Address address);

	boolean update(Address address);

	boolean delete(Address address);

}
