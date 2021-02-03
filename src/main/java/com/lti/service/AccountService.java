package com.lti.service;

import com.lti.model.Account;

public interface AccountService {
	public String addAccount(Account account);
	public double checkBalance(int accountNumber);
}
