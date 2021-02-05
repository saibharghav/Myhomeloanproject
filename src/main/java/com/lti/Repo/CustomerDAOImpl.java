package com.lti.Repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public void addUser(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println(customer.getCustId());
		System.out.println(customer);
		System.out.println(em);
		em.persist(customer);
		System.out.println("In the addUser() method");
		
	}
	
	@Override
	public int testLoginUser(String emailID, String passwordID) {
		// TODO Auto-generated method stub
//		 Query query=em.createQuery("select c.password from Customer c where c.email =: id");
//		 query.setParameter("id", emailID);
//		 query.getResultList();
		System.out.println(em.createQuery("select c.password from Customer c where c.email =: id").setParameter("id", emailID).getSingleResult());
		String pass=(String) em.createQuery("select c.password from Customer c where c.email =: id").setParameter("id", emailID).getSingleResult();
		if(pass.equals(passwordID))
		{
			System.out.println("Correct password");
			return 1;
		}
		System.out.println("Wrong password");
		return 0;
	}

	@Override
	public boolean isEmailPresent(String email) {
		// TODO Auto-generated method stud
		return (Long) em.createQuery("select count(c.email) from Customer c where c.email =: eml")
				.setParameter("eml", email).getSingleResult() == 1 ? true : false;
	}
	
	
	@Override
	public Customer getCustomerByEmail(String email)
	{
		Customer c1=(Customer) em.createQuery("select c from Customer c where c.email=:eml ").setParameter("eml",email).getSingleResult();
		return c1;
	}
			


}
