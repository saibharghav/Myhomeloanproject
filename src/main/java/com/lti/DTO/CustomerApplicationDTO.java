package com.lti.DTO;

import com.lti.model.Application;
import com.lti.model.Customer;

public class CustomerApplicationDTO {
	Customer customer;
	Application application;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
}