package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userid")
	private int userid;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="Insurance")
    private Insurance insurance;*/
	
	public User()
	{
		
	}

	public User(int userid,String username, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
	}
	
	public int getUserId() {
		return userid;
	}

	public void setUserId(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
