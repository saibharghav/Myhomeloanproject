package com.lti.Repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.DTO.ApplicationsDTO;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;
import com.lti.model.Tracker;


@Repository
public class ApplicationDAOImpl implements ApplicationDAO {
	
	@Autowired
	CustomerDAOImpl customerDAOImpl;
	@Autowired
	LoanDAOImpl loanDAOImpl;
	

	@PersistenceContext
	EntityManager em;

	@Transactional
	@Override
	public int addApplication(String email,Application application) {
		// TODO Auto-generated method stub
		System.out.println("In the addApplicationRepo method");
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
		em.persist(application);
		return application.getApplicationId();
	}
	
	@Override
	public  List<Application> getAllApplications()
	{
		System.out.println("In get all Applications method");
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
	
	
	@Override
	public List<ApplicationsDTO> getApplications() {
		// TODO Auto-generated method stub
		List<ApplicationsDTO> myApplicationsDTOList = new ArrayList<ApplicationsDTO>();
		
		System.out.println("Creating the query");
		Query query =em.createQuery(" from Application",Application.class);
		System.out.println("Getting the list");
		@SuppressWarnings("unchecked")
		List<Application> allApplications=query.getResultList();
		System.out.println("Got the list");
		Query query1;Loan l;String hql;
		for(Application App :allApplications)
		{
			int id = App.getApplicationId();
			System.out.println("ID IS: "+id);
			ApplicationsDTO myApplicationsDTO = new ApplicationsDTO();
			l=loanDAOImpl.getLoanByApplicationID(id);
			System.out.println(l.toString());
			System.out.println("--------------->"+App.getTracker().hashCode());
			Tracker t=App.getTracker();
//			hql="SELECT t from Tracker t join Application a ON a.applicationId=t.application and a.applicationId=:sa";
//			query1=em.createQuery(hql);
//			System.out.println("APP ID CHECKING....."+App.getApplicationId());
//			query1.setParameter("sa", App.getApplicationId());
//			Tracker t= (Tracker) query1.getSingleResult();
			System.out.println(t.toString());
			System.out.println("TRACKER ID CHECKING......"+t.getStatus());
			myApplicationsDTO.setApplicationId(App.getApplicationId());
			myApplicationsDTO.setAppToe(App.getAppToe());
			myApplicationsDTO.setEmpName(App.getEmpName());
			myApplicationsDTO.setLoanAmt(l.getLoanAmt());
			myApplicationsDTO.setEmiAmount(l.getEmiAmount());
			myApplicationsDTO.setSalary(App.getSalary());
			myApplicationsDTO.setStatus(t.getStatus());
			myApplicationsDTOList.add(myApplicationsDTO);
		}
		for(ApplicationsDTO a:myApplicationsDTOList)
		{
			System.out.println(a);
		}
		return myApplicationsDTOList;
	}

}

