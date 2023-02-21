package com.groupeisi.SecurityWeb.dao;

import java.util.List;

import com.groupeisi.SecurityWeb.entities.Comptes;

public interface IComptesdao {

	public int save (Comptes compte);
	public List<Comptes> getAll();
	public boolean login(String userName, String password);
}
