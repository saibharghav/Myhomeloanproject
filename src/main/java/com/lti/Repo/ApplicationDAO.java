package com.lti.Repo;

import java.util.List;

import com.lti.DTO.ApplicationsDTO;
import com.lti.model.Application;

public interface ApplicationDAO {
	 int addApplication(String email,Application application);
	 List<Application> getAllApplications();
	 Application getApplicationByID(int applicationID);
	 List<ApplicationsDTO> getApplications();
}

