package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.DTO.ApplicationsDTO;
import com.lti.DTO.CustomerApplicationDTO;
import com.lti.Repo.ApplicationDAOImpl;
import com.lti.Repo.CustomerDAOImpl;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;
import com.lti.model.Tracker;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	
	
	@PersistenceContext
	EntityManager em;

	@Autowired
	ApplicationDAOImpl applicationDao;
	
	@Autowired
	CustomerDAOImpl customerDao;
		
		@Override
		public int addApplication(CustomerApplicationDTO customerApplicationDTO) {
			Application application=new Application();
			Customer customer=new Customer();
			Tracker tracker=new Tracker();
			Loan loan=new Loan();
			try {
				System.out.println("In Service Layer");
				customer=customerDao.getCustomerByEmail(customerApplicationDTO.getEmail());

				String email=customer.getEmail();
				if(customer!=null)
				{
					application.setAadhar(customerApplicationDTO.getAadhar());
					application.setAadharno(customerApplicationDTO.getAadharno());
					application.setAgreement(customerApplicationDTO.getAgreement());
					application.setAppToe(customerApplicationDTO.getAppToe());
					application.setEmpName(customerApplicationDTO.getEmpName());
					application.setDob(customerApplicationDTO.getDob());
					application.setGender(customerApplicationDTO.getGender());
					application.setLoa(customerApplicationDTO.getLoa());
					application.setEstAmt(customerApplicationDTO.getEstAmt());
					application.setNationality(customerApplicationDTO.getNationality());
					application.setNoc(customerApplicationDTO.getNoc());
					application.setOrg(customerApplicationDTO.getOrg());
					application.setPan(customerApplicationDTO.getPan());
					application.setPanno(customerApplicationDTO.getPanno());
					application.setProLoc(customerApplicationDTO.getProLoc());
					application.setProName(customerApplicationDTO.getProName());
					application.setRetirAge(customerApplicationDTO.getRetirAge());
					application.setSalary(customerApplicationDTO.getSalary());
					application.setSalaryslp(customerApplicationDTO.getSalaryslp());
					application.setVoter(customerApplicationDTO.getVoter());
					application.setCustomer(customer);
					loan.setLoanAmt(customerApplicationDTO.getLoanAmt());
					loan.setTenure(customerApplicationDTO.getTenure());
					double ROI=8.5/(100*12);
					loan.setRoi(ROI);
					double amountemi,loanamt,Tenure;
					loanamt=customerApplicationDTO.getLoanAmt();
					Tenure=customerApplicationDTO.getTenure()*12;
					amountemi=loanamt*ROI*(Math.pow(1+ROI,Tenure))/(Math.pow(1-ROI,Tenure));
					loan.setEmiAmount(amountemi);
					loan.setMaxLoanamt(10000000);
					loan.setApplication(application);
					List<Loan>myLoan=new ArrayList();
					myLoan.add(loan);
					application.setLoans(myLoan);
					//Tracker Details
					tracker.setStatus("PENDING");
					tracker.setApplication(application);
					application.setTracker(tracker);
					
				}return applicationDao.addApplication(email,application);
//				else
//				{
//					return null;
//				}
			}
			catch(Exception e)
			{
                 throw e;
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
		
		
		@Override
		public List<ApplicationsDTO> allApplications() {
			// TODO Auto-generated method stub
			return applicationDao.getApplications();
		}
}
