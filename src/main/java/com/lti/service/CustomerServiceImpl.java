package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.Repo.CustomerDAOImpl;
import com.lti.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAOImpl customerRepo;
	
	@Override
	public String addUser(Customer customer) {
		// TODO Auto-generated method stub
		try
		{
			customerRepo.addUser(customer);
			return "Registered User Successfully";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}

	@Override
	public int testLoginUser(String email, String password) {
		// TODO Auto-generated method stub
		return customerRepo.testLoginUser(email, password);
	}

	@Override
	public boolean isEmailPresent(String email) {
		// TODO Auto-generated method stub
		return customerRepo.isEmailPresent(email);
	}

}
