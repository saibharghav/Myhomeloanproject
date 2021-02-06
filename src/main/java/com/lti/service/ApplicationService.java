package com.lti.service;

import java.util.List;

import com.lti.DTO.CustomerApplicationDTO;
import com.lti.model.Application;

public interface ApplicationService {
	String addApplication(CustomerApplicationDTO customerApplicationDTO);
	List<Application> getAllApplications();
	Application getApplicationByID(int applicationID);
}
