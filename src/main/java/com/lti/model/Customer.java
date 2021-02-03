package com.lti.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUST_ID")
	private long custId;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="MIDDLE_NAME")
	private String middleName;

	@Column(name="MOBILE_NUMBER")
	private long mobileNumber;

	private String password;

	@Column(name="PIN_CODE")
	private int pinCode;

	private String toe;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
	private List<Account> accounts;

	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
	private List<Application> applications;

	//bi-directional many-to-one association to Tracker
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL)
	private List<Tracker> trackers;

	public Customer() {
	}

	public long getCustId() {
		return this.custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public long getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getToe() {
		return this.toe;
	}

	public void setToe(String toe) {
		this.toe = toe;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setCustomer(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setCustomer(null);

		return account;
	}

	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Application addApplication(Application application) {
		getApplications().add(application);
		application.setCustomer(this);

		return application;
	}

	public Application removeApplication(Application application) {
		getApplications().remove(application);
		application.setCustomer(null);

		return application;
	}

	public List<Tracker> getTrackers() {
		return this.trackers;
	}

	public void setTrackers(List<Tracker> trackers) {
		this.trackers = trackers;
	}

	public Tracker addTracker(Tracker tracker) {
		getTrackers().add(tracker);
		tracker.setCustomer(this);

		return tracker;
	}

	public Tracker removeTracker(Tracker tracker) {
		getTrackers().remove(tracker);
		tracker.setCustomer(null);

		return tracker;
	}

}
