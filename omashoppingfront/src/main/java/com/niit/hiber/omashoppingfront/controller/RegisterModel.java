package com.niit.hiber.omashoppingfront.controller;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.niit.hiber.omashoppingbackend.dto.Address;
import com.niit.hiber.omashoppingbackend.dto.User;

@Component
public class RegisterModel implements Serializable {

	private static final long serialVersionUID = -1L;
	private User user;
	private Address billingAddress;

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
