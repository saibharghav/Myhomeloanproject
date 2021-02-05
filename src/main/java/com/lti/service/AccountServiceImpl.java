package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.Repo.AccountDAOImpl;
import com.lti.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAOImpl accountDAO;

	@Override
	public String addAccount(Account account) {
		try
		{
			accountDAO.addAccount(account);
			return "Account added Sucessfully";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		
	}

	@Override
	public double checkBalance(int accountNumber) {
		try
		{
			return accountDAO.checkBalance(accountNumber);
		}
		catch (Exception e)
		{
			return -1.0;//Check it in controller and respond
		}
		
	}


}
