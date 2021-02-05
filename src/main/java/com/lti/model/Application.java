package com.lti.model;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the APPLICATION database table.
 * 
 */
@Entity
@NamedQuery(name="Application.findAll", query="SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="APPLICATION_ID")
	private int applicationId;

	private String aadhar;

	private String aadharno;

	private String agreement;

	@Column(name="APP_TOE")
	private String appToe;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="EMP_NAME")
	private String empName;

	@Column(name="EST_AMT")
	private double estAmt;

	private String gender;

	private String loa;

	private String nationality;

	private String noc;

	private String org;

	private String pan;

	private String panno;

	@Column(name="PRO_LOC")
	private String proLoc;

	@Column(name="PRO_NAME")
	private String proName;

	@Column(name="RETIR_AGE")
	private int retirAge;

	private String salaryslp;

	private String voter;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	//bi-directional many-to-one association to Loan
	@OneToMany(mappedBy="application",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Loan> loans;

	//bi-directional one-to-one association to Tracker
	@OneToOne(mappedBy="application",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Tracker tracker;

	public Application() {
	}

	public int getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getAadhar() {
		return this.aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getAadharno() {
		return this.aadharno;
	}

	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}

	public String getAgreement() {
		return this.agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getAppToe() {
		return this.appToe;
	}

	public void setAppToe(String appToe) {
		this.appToe = appToe;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEstAmt() {
		return this.estAmt;
	}

	public void setEstAmt(double estAmt) {
		this.estAmt = estAmt;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLoa() {
		return this.loa;
	}

	public void setLoa(String loa) {
		this.loa = loa;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNoc() {
		return this.noc;
	}

	public void setNoc(String noc) {
		this.noc = noc;
	}

	public String getOrg() {
		return this.org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPanno() {
		return this.panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getProLoc() {
		return this.proLoc;
	}

	public void setProLoc(String proLoc) {
		this.proLoc = proLoc;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getRetirAge() {
		return this.retirAge;
	}

	public void setRetirAge(int retirAge) {
		this.retirAge = retirAge;
	}

	public String getSalaryslp() {
		return this.salaryslp;
	}

	public void setSalaryslp(String salaryslp) {
		this.salaryslp = salaryslp;
	}

	public String getVoter() {
		return this.voter;
	}

	public void setVoter(String voter) {
		this.voter = voter;
	}
	@JsonIgnore
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	//@JsonIgnore
	public List<Loan> getLoans() {
		return this.loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public Loan addLoan(Loan loan) {
		getLoans().add(loan);
		loan.setApplication(this);

		return loan;
	}

	public Loan removeLoan(Loan loan) {
		getLoans().remove(loan);
		loan.setApplication(null);

		return loan;
	}
	//@JsonIgnore
	public Tracker getTracker() {
		return this.tracker;
	}

	public void setTracker(Tracker tracker) {
		this.tracker = tracker;
	}

}