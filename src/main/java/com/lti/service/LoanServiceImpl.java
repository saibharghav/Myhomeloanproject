package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.Repo.LoanDAOImpl;
import com.lti.model.Loan;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDAOImpl loanDao;


	@Override
	public List<Loan> getLoans()  {
		try {
			return loanDao.getLoans();	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		      return null;
		}
		
	}

	@Override
	public String addLoan(Loan loan) {
		try {
			loanDao.addLoan(loan);
			return "Added sucessfully";
		}catch(Exception e) {
			System.out.println(e.getMessage());
		      return null;
		}
		
		
	}
	@Override
	public Loan getLoanByApplicationID(int a) {
		// TODO Auto-generated method stub
		return loanDao.getLoanByApplicationID(a);
	}

}
