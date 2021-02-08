package com.lti;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.DTO.ApplicationsDTO;
import com.lti.Repo.AccountDAOImpl;
import com.lti.Repo.ApplicationDAOImpl;
import com.lti.Repo.CustomerDAOImpl;
import com.lti.Repo.LoanDAOImpl;
import com.lti.Repo.TrackerDAOImpl;
import com.lti.model.Account;
import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;
import com.lti.model.Tracker;

@SpringBootTest
class HomeLoanProjectApplicationTests {

	@Autowired
	CustomerDAOImpl c1;
	@Autowired
	TrackerDAOImpl t1;
	@Autowired
	ApplicationDAOImpl ad1;
	@Autowired
	LoanDAOImpl l1;
	@Autowired
	AccountDAOImpl ac1;
	
	@Test
	void addCustomer() {
		System.out.println("In the test");
		Customer c = new Customer();
//		c.setCustId(12);
		c.setFirstName("First");
		c.setMiddleName("Middle_Name");
		c.setLastName("Last_Name");
		c.setEmail("email@email.com");
		c.setToe("Software");
		c.setMobileNumber(1212121212);
		c.setPinCode(34561);
		c.setPassword("***");
//		c.setAccounts(null);
//		c.setApplications(null);
//		c.setTrackers(null);
		c1.addUser(c);
		System.out.println("Added the test");
	}
	
	
	
//	@Test
//	void addCustomerWithAccounts() {
//		System.out.println("In the test");
//		Customer c = new Customer();
////		c.setCustId(12);
//		c.setFirstName("First");
//		c.setMiddleName("Middle_Name");
//		c.setLastName("Last_Name");
//		c.setEmail("email@email.com");
//		c.setToe("Software");
//		c.setMobileNumber(1212121212);
//		c.setPinCode(34561);
//		c.setPassword("***");
//		Account a=new Account();
////		a.setAccountnumber("A1");
//		a.setBalance(50000);
//		a.setCustomer(c);
//		List<Account> myAccountList= new ArrayList<Account>();
//		myAccountList.add(a);
//		c.setAccounts(myAccountList);
////		c.setApplications(null);
////		c.setTrackers(null);
//		c1.addUser(c);
//		System.out.println("Added the test");
//	}
	
	
//	@Test
//	void addCustomerWithApplicationWithAccounts() throws ParseException{
//		System.out.println("In the test");
//		Customer c = new Customer();
////		c.setCustId(12);
//		c.setFirstName("First");
//		c.setMiddleName("Middle_Name");
//		c.setLastName("Last_Name");
//		c.setEmail("email@email.com");
//		c.setToe("Software");
//		c.setMobileNumber(1212121212);
//		c.setPinCode(34561);
//		c.setPassword("***");
//		Account a=new Account();
////		a.setAccountnumber("A1");
//		a.setBalance(50000);
//		a.setCustomer(c);
//		List<Account> myAccountList= new ArrayList<Account>();
//		myAccountList.add(a);
//		c.setAccounts(myAccountList);
//		Application a1=new Application();
//		a1.setAadhar("Yes");
//		a1.setAadharno("345435245");
//		a1.setAgreement("Yes");
//		a1.setAppToe("Software");
//		a1.setEmpName("Bharghav");
//		a1.setEstAmt(1200000);
//		a1.setGender("Male");
//		a1.setLoa("Yes");
//		a1.setNationality("Indian");
//		a1.setNoc("Yes");
//		a1.setOrg("LTI");
//		a1.setPan("Yes");
//		a1.setPanno("989898");
//		a1.setProLoc("Hyderabad");
//		a1.setProName("Car");
//		a1.setRetirAge(60);
//		a1.setSalaryslp("Yes");
//		a1.setVoter("Yes");
//		a1.setCustomer(c);
//		a1.setDob(new SimpleDateFormat("dd-MM-yyyy").parse("27-8-1999"));
//		List<Application> myApplicationList= new ArrayList<Application>();
//		myApplicationList.add(a1);
//		c.setApplications(myApplicationList);
////		c.setTrackers(null);
//		c1.addUser(c);
//		System.out.println("Added the test");
//	}
	
	
	
	
	@Test 
	public void testVoidAddApplication() throws ParseException
	{
		Application a1=new Application();
		a1.setAadhar("Yes");
		a1.setAadharno("21412312");
		a1.setAgreement("Yes");
		a1.setAppToe("Software");
		a1.setEmpName("Nikhil");
		a1.setEstAmt(1200200);
		a1.setGender("Male");
		a1.setLoa("Yes");
		a1.setNationality("Indian");
		a1.setNoc("Yes");
		a1.setOrg("LTI");
		a1.setPan("Yes");
		a1.setPanno("989898");
		a1.setProLoc("Hyderabad");
		a1.setProName("Car");
		a1.setRetirAge(60);
		a1.setSalaryslp("Yes");
		a1.setVoter("Yes");
		a1.setDob(new SimpleDateFormat("dd-MM-yyyy").parse("17-1-1900"));
		System.out.println("Calling the test");
		ad1.addApplication("a@big.com",a1);
		System.out.println("Added the test");
	}

	
	@Test
	public void testAddLoan()
	{
		Loan loan=new Loan();
		loan.setEmiAmount(12000);
		loan.setLoanAmt(50000000);
		loan.setRoi(2.5);
		loan.setMaxLoanamt(100000000);
		loan.setTenure(4);
		System.out.println("Adding the loan");
		l1.addLoan(loan);
		System.out.println("Added the loan");
	}
	
	@Test
	public void testGetLoans()
	{
		System.out.println("Calling the DAO");
		List<Loan> myList=l1.getLoans();
		System.out.println("List is created");
		for(Loan loan:myList) {
			System.out.println(loan.getApplication().getApplicationId());
		}
	}
	
	
	@Test 
	public void testAddApplicationWithLoan() throws ParseException
	{
		Application a1=new Application();
		a1.setAadhar("Yes");
		a1.setAadharno("21412312");
		a1.setAgreement("Yes");
		a1.setAppToe("Software");
		a1.setEmpName("Vishal");
		a1.setEstAmt(1200000);
		a1.setGender("Female");
		a1.setLoa("Yes");
		a1.setNationality("Indian");
		a1.setNoc("Yes");
		a1.setOrg("LTI");
		a1.setPan("Yes");
		a1.setPanno("989898");
		a1.setProLoc("Hyderabad");
		a1.setProName("Car");
		a1.setRetirAge(60);
		a1.setSalaryslp("Yes");
		a1.setVoter("Yes");
		a1.setDob(new SimpleDateFormat("dd-MM-yyyy").parse("17-1-1900"));
		Loan loan=new Loan();
		loan.setEmiAmount(10500);
		loan.setLoanAmt(34560000);
		loan.setRoi(5.6);
		loan.setMaxLoanamt(112345000);
		loan.setTenure(6);
		loan.setApplication(a1);
		List<Loan> myLoanList=new ArrayList<Loan>();
		myLoanList.add(loan);
		a1.setLoans(myLoanList);
		System.out.println("Calling application repository..............");
		ad1.addApplication("a@big.com",a1);
	}
	
	
	
	@Test 
	public void testAddApplicationWithLoanWithTracker() throws ParseException
	{
		Application a1=new Application();
		a1.setAadhar("Yes");
		a1.setAadharno("21412312");
		a1.setAgreement("Yes");
		a1.setAppToe("Software");
		a1.setEmpName("Seema");
		a1.setEstAmt(1200000);
		a1.setGender("Female");
		a1.setLoa("Yes");
		a1.setNationality("Indian");
		a1.setNoc("Yes");
		a1.setOrg("LTI");
		a1.setPan("Yes");
		a1.setPanno("989898");
		a1.setProLoc("Hyderabad");
		a1.setProName("Car");
		a1.setRetirAge(60);
		a1.setSalaryslp("Yes");
		a1.setVoter("Yes");
		a1.setDob(new SimpleDateFormat("dd-MM-yyyy").parse("17-1-1900"));
		Loan loan=new Loan();
		loan.setEmiAmount(10500);
		loan.setLoanAmt(34560000);
		loan.setRoi(5.6);
		loan.setMaxLoanamt(112345000);
		loan.setTenure(6);
		loan.setApplication(a1);
		List<Loan> myLoanList=new ArrayList<Loan>();
		myLoanList.add(loan);
		a1.setLoans(myLoanList);
		Tracker t= new Tracker();
//		t.setStatus("Under Approval");
//		System.out.println("Application ID is "+a1.getApplicationId());
//		t.setApplication(a1);
//		a1.setTracker(t);
		t.setStatus("Pending");
		t.setApplication(a1);
		a1.setTracker(t);
		System.out.println("Calling application repository..............");
		ad1.addApplication("a@big.com",a1);
	}
	

	
	@Test
	public void testRejectStatus()
	{
		System.out.println("Reject Status calling");
		t1.rejectStatus(3);
	}
	
	
	@Test
	public void testApproveStatus()
	{
		System.out.println("Approve status calling");
		t1.approveStatus(3);
	}
	
	@Test
	public void testCheckStatus()
	{
		System.out.println("Calling Check Status........");
		System.out.println("The status is ------------>"+t1.checkStatus(3));
	}
	
	@Test 
	public void testCheckBalance()
	{
		System.out.println("Calling Check Balance.........");
		ac1.checkBalance(14);
	}
	
	@Test
	public void testGetAllApplications()
	{//Not Working
		System.out.println("Calling GetAllApplications........");
		ad1.getAllApplications();
	}
	
	@Test
	public void testGetApplicationByID()
	{
		Application a= new Application();
		a=ad1.getApplicationByID(2);
		System.out.println("Name is ->"+a.getEmpName());
		System.out.println("ID is -> "+a.getApplicationId());
		System.out.println("Type of employement is ->"+a.getAppToe());
	}
	
	@Test
	public void testGetLoanByAppID()
	{//Not Working
		Loan l=null;
		Application a= new Application();
		a=ad1.getApplicationByID(2);
		System.out.println("Name is ->"+a.getEmpName());
		System.out.println("ID is -> "+a.getApplicationId());
		System.out.println("Type of employement is ->"+a.getAppToe());
//		l=l1.getLoanByApplicationID(43);
		List<Loan> myList=a.getLoans();
		for (Loan loan : myList) {
			System.out.println("Loan Amount is ->"+loan.getLoanAmt());
			System.out.println("EMI Amount need to be paid is "+loan.getEmiAmount());
			System.out.println("Tenure for the Loan is "+loan.getTenure());
			System.out.println("----------------------");
		}
	
		
	}
	
	@Test
	public void testLoginUser()
	{
		boolean checkEmail=c1.isEmailPresent("email@email.com");
		if(checkEmail)
		{
			int check=c1.testLoginUser("email@email.com", "***");
			if (check==1)
			{
				System.out.println("Login success");
			}
			else
			{
				System.out.println("Wrong credentials");
			}
		}
		else
		{
			System.out.println("Invalid Email");
		}
	}
	
	@Test 
	public void getCustomerByEmailID()
	{
		Customer c=c1.getCustomerByEmail("a@big.com");
		System.out.println("CustomerID -------> "+c.getCustId());
		System.out.println("Customer Name -------> "+c.getMiddleName());
		
	}
	
	
	@Test
	public void AdminSeenDetails()
	{
		List<ApplicationsDTO> myList=ad1.getApplications();
		for(ApplicationsDTO a:myList)
		{
			System.out.println(a.getAppToe());
		}
	}
}
