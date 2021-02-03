package com.lti.model;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TRACKER database table.
 * 
 */
@Entity
@NamedQuery(name="Tracker.findAll", query="SELECT t FROM Tracker t")
public class Tracker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRACKER_ID")
	private int trackerId;

	private String status;

	//bi-directional one-to-one association to Application
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="APPLICATION_ID")
	private Application application;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	public Tracker() {
	}

	

	public int getTrackerId() {
		return trackerId;
	}



	public void setTrackerId(int trackerId) {
		this.trackerId = trackerId;
	}



	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}