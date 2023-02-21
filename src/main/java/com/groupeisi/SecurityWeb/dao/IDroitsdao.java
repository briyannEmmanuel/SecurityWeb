package com.groupeisi.SecurityWeb.dao;

import java.util.List;

import com.groupeisi.SecurityWeb.entities.Droits;

public interface IDroitsdao {

	public int save (Droits droits);
	public List<Droits> getAll();
	public Droits getOne(int id);
}
