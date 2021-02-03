package com.lti.Repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.Application;
import com.lti.model.Tracker;

@Repository
public class TrackerDAOImpl implements TrackerDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public Integer getStatusById(int a) {
//	Query query=  enitityManager.createQuery("select t.status from Tracker t where t.appId=:appId");
//	query.setParameter("appId", tracker.getApplicationId());
//	List<Integer> status=query.getResultList();
//	System.err.println("Status"+status.get(0));
//	return status.get(0);
		String loanStatus=(String) entityManager.createNativeQuery("Select t.status from Tracker where t.applicationId=:id").getSingleResult();
		System.out.println("Status---------> "+loanStatus);
		return null;
	}
	
	@Transactional
	@Override
	public void rejectStatus(int applicationID)
	{
		System.out.println("In TrackerDAOImple of reject status");
		String hql="UPDATE Tracker set status=:sa "+"WHERE application_id =: id";
		Query query=entityManager.createQuery(hql);
		query.setParameter("sa", "rejected");
		query.setParameter("id",applicationID);
		int result = query.executeUpdate();
		System.out.println("Query number is : "+result);
	}
	
	@Transactional
	@Override
	public void approveStatus(int applicationID)
	{
		System.out.println("In the Approve Status ");
		String hql="UPDATE Tracker set status=:sa "+"WHERE application_id =: id";
		Query query=entityManager.createQuery(hql);
		query.setParameter("sa", "Approved");
		query.setParameter("id",applicationID);
		int result = query.executeUpdate();
		System.out.println("Query number is : "+result);
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
