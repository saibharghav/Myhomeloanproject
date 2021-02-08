package com.lti.model;
import java.io.Serializable;
import javax.persistence.*;

import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the TRACKER database table.
 * 
 */
@Entity
@Scope(value="prototype")
@NamedQuery(name="Tracker.findAll", query="SELECT t FROM Tracker t")
public class Tracker implements Serializable {
	private static final long serialVersionUID = 1L;
	private String status;
	//bi-directional one-to-one association to Application
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "APPLICATION_ID")
	private Application application;
	public Tracker() {
	}
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@JsonIgnore
	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}