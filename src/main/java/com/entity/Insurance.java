package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="insurance")
public class Insurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="insuranceProvider")
	private String insuranceProvider;
	@Column(name="insuranceNumber")
	private long insuranceNumber;
	@Column(name="validDate")
	private String validDate;
	
	/*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_id")
	private User user;*/
	
	public Insurance()
	{
		
	}

	public Insurance( int id,String insuranceProvider, long insuranceNumber, String validDate) {
		super();
		this.id = id;
		this.insuranceProvider = insuranceProvider;
		this.insuranceNumber = insuranceNumber;
		this.validDate = validDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public long getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(long insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	
	/*public User getUser() {
        return user;
        
    }
	
    public void setUser(User user) {
        this.user = user;
        
    }*/

}
