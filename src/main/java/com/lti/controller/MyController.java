package com.lti.controller;

import java.util.List;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Application;
import com.lti.model.Customer;
import com.lti.model.Loan;
import com.lti.model.Tracker;
import com.lti.service.AccountServiceImpl;
import com.lti.service.ApplicationServiceImpl;
import com.lti.service.CustomerServiceImpl;
import com.lti.service.LoanServiceImpl;
import com.lti.service.TrackerServiceImpl;

@RestController
@CrossOrigin
public class MyController {
	
	
	@Autowired
	LoanServiceImpl loanService;
	@Autowired 
	AccountServiceImpl accountService;
	@Autowired
	ApplicationServiceImpl applicationService;
	@Autowired
	CustomerServiceImpl customerService;
	@Autowired
	TrackerServiceImpl trackerService;
	
	@GetMapping("/home")
	public String homePage()
	{
		return "Welcome Home";
	}
	
	
	
	@GetMapping("/loan")
	public List<Loan> showLoans()
	{
		return loanService.getLoans();
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer)
	{
		customerService.addUser(customer);
		return "User is created";
	}
	
	

	@PostMapping("/isEmail")
	public boolean loginTest(@RequestBody Customer customer)
	{
		System.out.println(customerService.isEmailPresent(customer.getEmail()));
		return customerService.isEmailPresent(customer.getEmail());
	}
//	@PostMapping("/loginTest")
//	public String loginTest1(@RequestBody Customer customer)
//	{
//		boolean check=customerService.isEmailPresent(customer.getEmail());
//		if(check)
//		{
//			int a= customerService.testLoginUser(customer.getEmail(), customer.getPassword());
//			if(a==1)
//				return "Correct User Welcome";
//			return "Invalid crendentials";
//		}
//		return "Invalid email ID";
//	}
	
	@PostMapping("/checkStatus/{a}")
	@ResponseBody
	public String checkStatus(@PathVariable("a") Integer a)
	{
		String status=trackerService.checkStatus(a);
		System.out.println("Status is "+status);
		return status;
	}
	
	@PostMapping("/getBalance/{a}")
	@ResponseBody
	public double getBalance(@PathVariable("a") Integer a)
	{
		double balance=accountService.checkBalance(a);
		return balance;
	}
	
	@PutMapping("/status/{a}/{b}")
	@ResponseBody
	public String changeStatus(@PathVariable Map<String,String> status)
	{
		String a=status.get("a");
		int b=Integer.parseInt(status.get("b"));
		if(a.equals("Reject"))
		{
			trackerService.rejectStatus(b);
			return "Rejected";
		}
		else
		{
			trackerService.approveStatus(b);
		}
		return "approved";
	}
	
	
	@GetMapping("/loginTest/{email}/{password}")
	@ResponseBody
	public String loginTest(@PathVariable Map<String,String> LoginTest)
	{
		String Email=LoginTest.get("email");
		String Password=LoginTest.get("password");
		System.out.println(Email+"  "+Password);
		boolean check=customerService.isEmailPresent(Email);
		if(check)
		{
				int a= customerService.testLoginUser(Email,Password);
				if(a==1)
					return "Correct User Welcome";
				return "Invalid crendentials";
		}
		return "Invalid Email";
	}
	
	@GetMapping("/application")
	public List<Application> getAllApplications()
	{
		return applicationService.getAllApplications();
	}
	
	@PostMapping("/ApplicationForm")
	@ResponseBody
	public String applicationForm(@RequestParam String email, @RequestBody Application application)
	{
		
		return applicationService.addApplication(email,application);
		
	}
	
	
	
	
	
	
}
