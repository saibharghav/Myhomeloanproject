package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.Repo.TrackerDAOImpl;
import com.lti.model.Tracker;

@Service
public class TrackerServiceImpl implements TrackerService {

	@Autowired
	TrackerDAOImpl trackerDAO;
	@Override
	public void rejectStatus(int applicationID) {
		// TODO Auto-generated method stub
		try
		{
			trackerDAO.rejectStatus(applicationID);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void approveStatus(int applicationID) {
		// TODO Auto-generated method stub
		try
		{
			trackerDAO.approveStatus(applicationID);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String checkStatus(int applicationID) {
		// TODO Auto-generated method stub
		try
		{
			String stat=trackerDAO.checkStatus(applicationID);
			if(stat!=null)
				return stat;
			else
				return "No application form";
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
