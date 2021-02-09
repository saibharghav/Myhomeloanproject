package com.lti.Repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.Account;
import com.lti.model.Application;
import com.lti.model.Tracker;

@Repository
public class TrackerDAOImpl implements TrackerDAO {
	
	@Autowired
	AccountDAOImpl accDAO;
	
	@Autowired
	ApplicationDAOImpl appDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public Integer getStatusById(int a) {
		String loanStatus=(String) entityManager.createNativeQuery("Select t.status from Tracker where t.applicationId=:id").getSingleResult();
		System.out.println("Status---------> "+loanStatus);
		return null;
	}
	
	@Transactional
	@Override
	public void rejectStatus(int applicationID)
	{
		System.out.println("In TrackerDAOImple of reject status");
		String hql="UPDATE Tracker t SET t.status=:sa "+"WHERE t.application =: id";
		Query query=entityManager.createQuery(hql);
		query.setParameter("sa", "rejected");
		query.setParameter("id",appDAO.getApplicationByID(applicationID));
		int result = query.executeUpdate();
		System.out.println("Query number is : "+result);
//	
//		ApplicationDAOImpl appDAO=new App;
//		Application app=appDAO.getApplicationByID(applicationID);
		
	}
	
	@Transactional
	@Override
	public void approveStatus(int applicationID)
	{
		System.out.println("In the Approve Status ");
		String hql="UPDATE Tracker set status=:sa WHERE application_id =: id";
		Query query=entityManager.createQuery(hql);
		query.setParameter("sa", "Approved");
		query.setParameter("id",applicationID);
		int result = query.executeUpdate();
		System.out.println("Query number is : "+result);
		System.out.println("Creating an Account row");
		Account a=new Account();
		String hql1="SELECT loanAmt from Loan "+"WHERE application_id=:id";
		Query query1=entityManager.createQuery(hql1);
		query1.setParameter("id", applicationID);
		double balance=(double) query1.getSingleResult();
		System.out.println("Loan amount asked is "+balance);
		a.setAccountnumber(applicationID);
		balance-=balance*0.15;
		System.out.println("Loan amount sanctioned is "+balance);
		a.setBalance(balance);
		System.out.println(accDAO.addAccount(a));
	}
	
	@Override
	public String checkStatus(int applicationNumber)
	{
		System.out.println("In the Check Status method");
		Query query1=entityManager.createQuery("select a from Application a where a.applicationId=:id").setParameter("id", applicationNumber);
		Application a=(Application) query1.getSingleResult();
		System.out.println("Application table ID is "+a.getApplicationId());
		Tracker t=a.getTracker();
		return t.getStatus();
	}
}
