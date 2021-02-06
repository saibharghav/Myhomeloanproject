package com.lti.Repo;

import java.util.List;

import com.lti.model.Application;

public interface ApplicationDAO {
	 String addApplication(String email,Application application);
	 List<Application> getAllApplications();
	 Application getApplicationByID(int applicationID);
}

