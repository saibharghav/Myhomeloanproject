package com.lti.Repo;

import java.util.List;

import com.lti.model.Application;
import com.lti.model.Loan;

public interface LoanDAO {
	void addLoan(Loan loan);
	List<Loan> getLoans();
	Loan getLoanByApplicationID(int a);
}
