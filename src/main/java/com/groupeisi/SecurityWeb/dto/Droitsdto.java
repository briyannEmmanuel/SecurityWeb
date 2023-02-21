package com.groupeisi.SecurityWeb.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Droitsdto {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getComptes() {
		return comptes;
	}
	public void setComptes(List<String> comptes) {
		this.comptes = comptes;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name="name", nullable=false, length=200, unique=true)
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<String> comptes = new ArrayList<String>();
}
