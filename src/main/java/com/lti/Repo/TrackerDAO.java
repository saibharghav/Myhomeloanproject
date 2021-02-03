package com.lti.Repo;

import com.lti.model.Tracker;

public interface TrackerDAO {
	public Integer getStatusById(int a);
	void rejectStatus(int applicationID);
	void approveStatus(int applicationID);
	String checkStatus(int applicationID);
}
