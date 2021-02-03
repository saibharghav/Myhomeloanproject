package com.lti.Repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.Application;
import com.lti.model.Loan;

@Repository
public class LoanDAOImpl implements LoanDAO {
	
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public void addLoan(Loan loan) {
		// TODO Auto-generated method stub
		System.out.println("In the addLoan() method");
		em.persist(loan);
	}
	@Transactional
	@Override
	public List<Loan> getLoans() {
		// TODO Auto-generated method stub
		System.out.println("In DAO");
		Query query=em.createQuery(" from Loan");
		System.out.println("Query Executed and Resultlist");
		List<Loan> listLoan=query.getResultList();
		System.out.println("Returing the resultList");
		return listLoan;
	}
	
	@Override
	public Loan getLoanByApplicationID(int a) {
		// TODO Auto-generated method stub
		String hql="SELECT l FROM Loan l join Application a WHERE a.applicationId=l.application and a.applicationId=:sa";
		Query query=em.createQuery(hql);
		query.setParameter("sa", a);
		return (Loan) query.getSingleResult();
	}

}
