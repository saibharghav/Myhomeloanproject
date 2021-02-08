package com.lti.service;

import java.util.List;

import com.lti.DTO.ApplicationsDTO;
import com.lti.DTO.CustomerApplicationDTO;
import com.lti.model.Application;

public interface ApplicationService {
	int addApplication(CustomerApplicationDTO customerApplicationDTO);
	List<Application> getAllApplications();
	Application getApplicationByID(int applicationID);
	List<ApplicationsDTO> allApplications();
}
