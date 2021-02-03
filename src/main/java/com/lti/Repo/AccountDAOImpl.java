package com.lti.Repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public String addAccount(Account account) {
		// TODO Auto-generated method stub
		System.out.println("In the addAccount() method");
		em.persist(account);
		return "Added";
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public double checkBalance(int accountNumber)
	{
		System.out.println("In the check Balance method.........");
//		String hql="SELECT balance from Account WHERE accountnumber =:id";
//		Query query = em.createQuery(hql);
//		query.setParameter("id", accountNumber);
//		System.out.println("Get Query list.......");
//		List<Double> results= query.getResultList();
//		for(Double result:results)
//		{
//			System.out.println("Balance-------------------> "+result);
//		}
//		double balance=(double) query.getSingleResult();
//		System.out.println(balance);
		
		Query query= em.createQuery(" from Account",Account.class);
		System.out.println("Query started....");
		List<Account> myList= query.getResultList();
		for (Account account : myList) {
			if(account.getAccountnumber()==accountNumber)
			{
				System.out.println("Balance--------------> "+account.getBalance());
				return account.getBalance();
			}
		}
		return 0.0;
		
	}

}
