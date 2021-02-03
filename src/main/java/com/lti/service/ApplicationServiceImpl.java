package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.Repo.ApplicationDAOImpl;
import com.lti.model.Application;

public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationDAOImpl applicationDao;
		
		@Override
		public String addApplication(Application application) {
			try {
				 return "Your application ID is "+applicationDao.addApplication(application).getApplicationId();
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
