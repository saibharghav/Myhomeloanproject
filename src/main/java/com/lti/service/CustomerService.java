package com.lti.service;

import com.lti.model.Customer;

public interface CustomerService {
	String addUser(Customer customer);
	int testLoginUser(String email,String password);
	boolean isEmailPresent(String email);
}
