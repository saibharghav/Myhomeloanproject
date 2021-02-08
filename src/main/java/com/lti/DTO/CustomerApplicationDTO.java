package com.lti.DTO;

import java.sql.Date;

import com.lti.model.Application;
import com.lti.model.Customer;

public class CustomerApplicationDTO {
	public String email;//CustomerEmail
	//Application Details
	public String aadhar;
	public String aadharno;
	public String agreement;
	public String appToe;
	public String empName;
	public Date dob;
	public String gender;
	public String loa;
	public double estAmt;
	public String nationality;
	public String noc;
	public String org;
	public String pan;
	public String panno;
	public String proLoc;
	public String proName;
	public int retirAge;
	public double salary;
	
	public String salaryslp;
	public String voter;
	//Loan Details
	public double loanAmt;
	public double roi;
	public double tenure;
	//Tracker Details
	public String status;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getAadharno() {
		return aadharno;
	}
	public void setAadharno(String aadharno) {
		this.aadharno = aadharno;
	}
	public String getAgreement() {
		return agreement;
	}
	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}
	public String getAppToe() {
		return appToe;
	}
	public void setAppToe(String appToe) {
		this.appToe = appToe;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLoa() {
		return loa;
	}
	public void setLoa(String loa) {
		this.loa = loa;
	}
	public double getEstAmt() {
		return estAmt;
	}
	public void setEstAmt(double estAmt) {
		this.estAmt = estAmt;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getNoc() {
		return noc;
	}
	public void setNoc(String noc) {
		this.noc = noc;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getPanno() {
		return panno;
	}
	public void setPanno(String panno) {
		this.panno = panno;
	}
	public String getProLoc() {
		return proLoc;
	}
	public void setProLoc(String proLoc) {
		this.proLoc = proLoc;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getRetirAge() {
		return retirAge;
	}
	public void setRetirAge(int retirAge) {
		this.retirAge = retirAge;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getSalaryslp() {
		return salaryslp;
	}
	public void setSalaryslp(String salaryslp) {
		this.salaryslp = salaryslp;
	}
	public String getVoter() {
		return voter;
	}
	public void setVoter(String voter) {
		this.voter = voter;
	}
	public double getLoanAmt() {
		return loanAmt;
	}
	public void setLoanAmt(double loanAmt) {
		this.loanAmt = loanAmt;
	}
	public double getRoi() {
		return roi;
	}
	public void setRoi(double roi) {
		this.roi = roi;
	}
	public double getTenure() {
		return tenure;
	}
	public void setTenure(double tenure) {
		this.tenure = tenure;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}