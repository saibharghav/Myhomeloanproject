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

import com.lti.DTO.ApplicationsDTO;
import com.lti.DTO.CustomerApplicationDTO;
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
@CrossOrigin(origins="http://localhost:4200")
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
	
	
	@GetMapping("/checkStatus/{a}")
	@ResponseBody
	public String checkStatus(@PathVariable("a") Integer a)
	{
		String status=trackerService.checkStatus(a);
		System.out.println(status);
		return status;
	}
	
	@GetMapping("/getBalance/{a}")
	@ResponseBody
	public String getBalance(@PathVariable("a") Integer a)
	{
		double balance=accountService.checkBalance(a);
		if(balance>0)
		{
			return Double.toString(balance);
		}
		return "Invalid Account ID";
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
	
	
	@PostMapping("/loginTest")
	@ResponseBody
	public Customer loginTest1(@RequestBody Customer customer)
	{

		boolean check=customerService.isEmailPresent(customer.getEmail());
		
		if(check)
		{
			int a=customerService.testLoginUser(customer.getEmail(), customer.getPassword());
			if(a==1) {
				Customer c=customerService.getCustomerByEmail(customer.getEmail());
				return c;
			}
			return null;
		}
		return null;
	}
	
	@GetMapping("/application")
	public List<Application> getAllApplications()
	{
		return applicationService.getAllApplications();
	}
	

	
	@PostMapping("/AddApplication")
	@ResponseBody
	public int addApplication(@RequestBody CustomerApplicationDTO customerApplicationDTO)
	{
		return applicationService.addApplication(customerApplicationDTO);
	}
	
	@GetMapping("/allApplications")
	@ResponseBody
	public List<ApplicationsDTO> getApplications()
	{
		return applicationService.allApplications();
	}
	
	@PutMapping("/approveStatus/{ID}")
	@ResponseBody
	public int approveStatus(@PathVariable("ID") int ID)
	{
		trackerService.approveStatus(ID);
		return 1;
	}
	
	@PutMapping("/rejectStatus/{ID}") //   /rejectStatus/5
	@ResponseBody
	public int rejectStatus(@PathVariable("ID") int ID)
	{
		trackerService.rejectStatus(ID);
		return 3;
	}
}
