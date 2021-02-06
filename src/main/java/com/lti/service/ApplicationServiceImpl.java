package com.lti.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.DTO.CustomerApplicationDTO;
import com.lti.Repo.ApplicationDAOImpl;
import com.lti.model.Application;
import com.lti.model.Customer;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	@PersistenceContext
	EntityManager em;

	@Autowired
	ApplicationDAOImpl applicationDao;
		
		@Override
		public String addApplication(CustomerApplicationDTO customerApplicationDTO) {
			try {
				System.out.println("In Service Layer");
				String email=customerApplicationDTO.getCustomer().getEmail();
				Application application=customerApplicationDTO.getApplication();
				 
				 return applicationDao.addApplication(email,application);
			}
			catch(Exception e)
			{
			      return e.getMessage();
			}
			
		}
		@Override
		public List<Application> getAllApplications() {
			try {
				return applicationDao.getAllApplications();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			      return null;
			}
		}
		@Override
		public Application getApplicationByID(int applicationID) {
			try {
				 return applicationDao.getApplicationByID(applicationID);	
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			      return null;
			}
		}
}
