package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.Repo.ApplicationDAOImpl;
import com.lti.model.Application;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationDAOImpl applicationDao;
		
		@Override
		public String addApplication(String email,Application application) {
			try {
				System.out.println("In Service Layer");
				 applicationDao.addApplication(email,application);
				 return "Application Added";
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
