package com.lti.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the LOAN database table.
 * 
 */
@Entity
@NamedQuery(name="Loan.findAll", query="SELECT l FROM Loan l")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int loanid;

	@Column(name="EMI_AMOUNT")
	private double emiAmount;

	@Column(name="LOAN_AMT")
	private double loanAmt;

	@Column(name="MAX_LOANAMT")
	private double maxLoanamt;

	private double roi;

	private double tenure;

	//bi-directional many-to-one association to Application
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="APPLICATION_ID")
	private Application application;

	public Loan() {
	}

	public int getLoanid() {
		return this.loanid;
	}

	public void setLoanid(int loanid) {
		this.loanid = loanid;
	}

	public double getEmiAmount() {
		return this.emiAmount;
	}

	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public double getLoanAmt() {
		return this.loanAmt;
	}

	public void setLoanAmt(double loanAmt) {
		this.loanAmt = loanAmt;
	}

	public double getMaxLoanamt() {
		return this.maxLoanamt;
	}

	public void setMaxLoanamt(double maxLoanamt) {
		this.maxLoanamt = maxLoanamt;
	}

	public double getRoi() {
		return this.roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

	public double getTenure() {
		return this.tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}
	@JsonIgnore
	
	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}