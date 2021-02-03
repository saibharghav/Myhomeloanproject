package com.lti.Repo;

import com.lti.model.Account;

public interface AccountDAO {
	public double checkBalance(int accountNumber);
	public String addAccount(Account account);
}
