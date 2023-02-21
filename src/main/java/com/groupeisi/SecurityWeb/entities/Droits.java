package com.groupeisi.SecurityWeb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.groupeisi.SecurityWeb.entities.Comptes;

@SuppressWarnings({ "serial", "unused" })
@Entity
@Table(name="droits")
public class Droits implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "name", nullable = false, length = 200, unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "droits")
	private List<Comptes> comptes = new ArrayList<Comptes>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setComptes(List<Comptes> comptes) {
		this.comptes = comptes;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Comptes> getComptes() {
		return comptes;
	}
	public void setUsers(List<Comptes> comptes) {
		this.comptes = comptes;
	}
}
