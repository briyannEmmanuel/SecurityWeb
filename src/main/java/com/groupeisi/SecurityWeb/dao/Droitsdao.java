package com.groupeisi.SecurityWeb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.groupeisi.SecurityWeb.dao.IDroitsdao;
import com.groupeisi.SecurityWeb.config.HibernateUtil;
import com.groupeisi.SecurityWeb.dao.Comptesdao;
import com.groupeisi.SecurityWeb.dto.Droitsdto;
import com.groupeisi.SecurityWeb.entities.Comptes;
import com.groupeisi.SecurityWeb.entities.Droits;

@SuppressWarnings("unused")
public class Droitsdao implements IDroitsdao {

	private Session session;
	private Transaction transaction;
	
	public Droitsdao () {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public Droits getByNom(String nom) {
		
		return (Droits) session.createQuery("FROM Droit d WHERE d.nom = :d_nom")
				.setParameter("d_nom", nom).uniqueResult();
	}
	
	public int save(Droits droits) {
		try {
			transaction = session.beginTransaction();
			session.save(droits);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}


	@SuppressWarnings("unchecked")
	public List<Droits> getAll() {
		return session.createQuery("select droit from Droit droit").getResultList();
		
	}

	@Override
	public Droits getOne(int l) {
		return session.get(Droits.class, l);
	}
	

	

	public Droits DriotDtoToDriotEntity (Droitsdto droitsdto) {
		Droits droits = new Droits();
		droits.setId(droitsdto.getId());
		droits.setName(droitsdto.getName());
		if (droitsdto.getComptes() != null) {
			List<Comptes> comptes = new ArrayList<Comptes>();
			droitsdto.getComptes().forEach(userName->{
				Comptes compte = new Comptesdao().getByUserName(userName);
				comptes.add(compte);
			});
			droits.setComptes(comptes);
		}
		
		return droits;
	}

	public Droitsdto DroitEntityToDroitDto (Droits droits) {
		Droitsdto droitsdto = new Droitsdto();
		droitsdto.setId(droits.getId());
		droitsdto.setName(droits.getName());
		if (droits.getComptes() != null) {
			List<String> comptes = new ArrayList<String>();
			droits.getComptes().forEach(compte->{
				comptes.add(compte.getUserName());
			});
			droitsdto.setComptes(comptes);
		}
		
		return droitsdto;
	}

	public List<Droitsdto> ListDriotToListDriotDto (List<Droits> droits) {
		List<Droitsdto> droitsdto = new ArrayList<Droitsdto>();
		if (droits != null) {
			droits.forEach(droit->
			droitsdto.add(DroitEntityToDroitDto(droit))
			);
		}
		
		return droitsdto;
	}
}
