package com.groupeisi.SecurityWeb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="comptes")
public class Comptes implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "userName", nullable = false, length = 200)
	private String userName;
	
	@Column (name = "password", nullable = false, length = 200)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Droits> droits = new ArrayList<Droits>();
	
	

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
	public List<Droits> getDroits() {
		return droits;
	}
	public void setDroits(List<Droits> droits) {
		this.droits = droits;
	}

}
