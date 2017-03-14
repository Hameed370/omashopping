package com.niit.hiber.omashoppingfront.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.hiber.omashoppingbackend.dao.AddressDAO;
import com.niit.hiber.omashoppingbackend.dao.UserDAO;
import com.niit.hiber.omashoppingbackend.dto.Address;
import com.niit.hiber.omashoppingbackend.dto.User;

@Component
public class RegisterHandler {
	@Autowired
	private UserDAO userDAO;
	@SuppressWarnings("unused")
	@Autowired
	private AddressDAO addressDAO;

	// if you have a separate model
	public RegisterModel initFlow() {
		return new RegisterModel();
	}

	public String saveUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
		return null;

	}

	public String saveAddress(RegisterModel registerModel, Address address) {
		registerModel.setBillingAddress(address);
		return null;
	}

	public String saveRegistrationDetails(RegisterModel registerModel) {
		String status = "success";
		User user = registerModel.getUser();
				
		// save the user userDAO.add(user);
		Address billingAddress = registerModel.getBillingAddress();

		user.getAddresses().add(billingAddress);
		//user.getAddress().add(billingAddress);

		// set the user
		billingAddress.setUser(user);
		
		// save the billing address
		userDAO.add(user);
//		addressDAO.add(billingAddress);
		
		return status;

	}
	// if user is not supplier
	
	 /* if (user.getRole().equals("CUSTOMER")) { 
		  Cart cart = new Cart(); // set the user
		  cart.setUser(user); // save the cart 
		  userDAO.addUserCart(cart);
	  }*/
	 
}
