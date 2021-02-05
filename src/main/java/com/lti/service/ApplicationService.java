package com.lti.service;

import java.util.List;

import com.lti.model.Application;

public interface ApplicationService {
	String addApplication(String email,Application application);
	List<Application> getAllApplications();
	Application getApplicationByID(int applicationID);
}
