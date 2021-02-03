package com.lti.service;

import java.util.List;

import com.lti.model.Loan;

public interface LoanService {
	Loan getLoanByApplicationID(int a);
	String addLoan(Loan loan);
	List<Loan> getLoans();
	
}	
