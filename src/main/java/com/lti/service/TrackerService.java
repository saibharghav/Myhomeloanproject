package com.lti.service;

import com.lti.model.Tracker;

public interface TrackerService {
	void rejectStatus(int applicationID);
	void approveStatus(int applicationID);
	String checkStatus(int applicationID);
}
