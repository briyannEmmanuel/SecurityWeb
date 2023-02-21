package com.groupeisi.SecurityWeb.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Comptesdto {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getDroits() {
		return droits;
	}
	public void setDroits(List<String> droits) {
		this.droits = droits;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name="userName", nullable=false, length=200, unique=true)
	private String userName;
	
	@Column (name="password", nullable=false, length=200, unique=true)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<String> droits = new ArrayList<String>();
}
