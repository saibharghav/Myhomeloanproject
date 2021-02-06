package com.lti.Repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;
import com.lti.model.Tracker;


@Repository
public class ApplicationDAOImpl implements ApplicationDAO {
	
	@Autowired
	CustomerDAOImpl customerDAOImpl;
	
	@PersistenceContext
	EntityManager em;

	@Transactional
	@Override
	public String addApplication(String email,Application application) {
		// TODO Auto-generated method stub
		System.out.println("In the addApplicationRepo method");
		//System.out.println("ApplicationID is "+application.getApplicationId());
		//===================================================
		Customer c1=customerDAOImpl.getCustomerByEmail(email);
		Customer c=em.find(Customer.class,c1.getCustId());
		application.setCustomer(c);
		List<Application> applicationList=new ArrayList<Application>();
		c.setApplications(applicationList);
		Tracker t=application.getTracker();
		t.setApplication(application);
		application.setTracker(t);
		List<Loan> l=application.getLoans();
		for (Loan loan : l) {
			loan.setApplication(application);
		}
		application.setLoans(l);
		//===================================================
		em.persist(application);
		return "Application Added and your application ID is "+application.getApplicationId();
	}
	
	@Override
	public  List<Application> getAllApplications()
	{
		System.out.println("In get all Applications method");
		//String hql="select a.application_id,a.aadharno,a.emp_name,l.loan_amt,l.emi_amount,l.tenure,t.status from Application a join Loan l join Tracker t where a.application_id=l.application_id and l.application_id=t.application_id";
		//String hql="select a.application_id,a.emp_name,l.loan_amt,l.emi_amount from application a inner join loan l on a.application_id=l.application_id";
		//String hql1="SELECT a.applicationId,a.empName,l.loanAmt,l.emiAmount,l.tenure,t.status from Application a join fetch Loan l join Tracker t on a.applicationId=l.application and a.applicationId=t.application";
		
		Query query = em.createQuery(" from Application",Application.class);
		System.out.println("Progressing the list.........");
		@SuppressWarnings("unchecked")
		List<Application> list=query.getResultList();
		for (Application app : list) {
			System.out.println(app.getApplicationId());
			Tracker track=app.getTracker();
			if(track!=null)
			{
				System.out.println(app.getTracker().getStatus());
			}
			else
			{
				System.out.println("NO tracker");
			}
			//System.out.println(app.getTracker().getStatus());
			List<Loan> myList=app.getLoans();
			for (Loan loan : myList) {
				System.out.println("Loan Amount is ->"+loan.getLoanAmt());
				System.out.println("EMI Amount need to be paid is "+loan.getEmiAmount());
				System.out.println("Tenure for the Loan is "+loan.getTenure());
				System.out.println("----------------------");
			}
		}
		return list;
		
	}
	
	@Override
	public Application getApplicationByID(int applicationID)
	{
		String hql="SELECT a from Application a WHERE applicationId=:sa";
		Query query=em.createQuery(hql);
		query.setParameter("sa", applicationID);
		return (Application) query.getSingleResult();
	}

}

