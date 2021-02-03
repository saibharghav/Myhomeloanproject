package com.lti.Repo;

import com.lti.model.Customer;

public interface CustomerDAO {
	void addUser(Customer customer);
	int testLoginUser(String email,String password);
	boolean isEmailPresent(String email);
}
