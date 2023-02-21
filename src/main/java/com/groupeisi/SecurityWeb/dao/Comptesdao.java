package com.groupeisi.SecurityWeb.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.groupeisi.SecurityWeb.dao.IComptesdao;
import com.groupeisi.SecurityWeb.config.HibernateUtil;
import com.groupeisi.SecurityWeb.dao.Droitsdao;
import com.groupeisi.SecurityWeb.dto.Comptesdto;
import com.groupeisi.SecurityWeb.entities.Comptes;
import com.groupeisi.SecurityWeb.entities.Droits;

@SuppressWarnings("unused")
public class Comptesdao implements IComptesdao {

	private Session session;
	private Transaction transaction;
	
	public Comptesdao () {
		session = HibernateUtil.getSessionFactory().openSession();
	}
	
	public int save(Comptes comptes) {
		try {
			transaction = session.beginTransaction();
			session.save(comptes);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Comptes> getAll() {
		return session.createQuery("select comptes from Comptes comptes").getResultList();
		
	}

	public boolean login(String userName, String password) {

		Comptes user = null;
		try {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = (Comptes) session.createQuery("FROM Comptes U WHERE U.userName = :userName").setParameter("userName", userName)
					.uniqueResult();
			
			if(user != null && user.getPassword().equals(password)) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}
	

	public Comptes getByUserName(String userName) {
		
		//return (AppUser) session.get(AppUser.class, email); //A revoir
		return (Comptes) session.createQuery("FROM Comptes c WHERE c.userName = :c_userName")
				.setParameter("c_userName", userName).uniqueResult();
	}
	

	public Comptes CompteDtoToCompteEntity (Comptesdto comptedto) {
		Comptes compte = new Comptes();
		compte.setId(comptedto.getId());
		compte.setUserName(comptedto.getUserName());
		compte.setPassword(comptedto.getPassword());
		if (comptedto.getDroits() != null) {
			List<Droits> droits = new ArrayList<Droits>();
			comptedto.getDroits().forEach(userName->{
				Droits droit = new Droitsdao().getByNom(userName);
				droits.add(droit);
			});
			compte.setDroits(droits);
		}
		
		return compte;
	}

	public Comptesdto CompteEntityToCompteDto (Comptes compte) {
		Comptesdto comptedto = new Comptesdto();
		comptedto.setId(compte.getId());
		comptedto.setUserName(compte.getUserName());
		comptedto.setPassword(compte.getPassword());
		if (compte.getDroits() != null) {
			List<String> droits = new ArrayList<String>();
			compte.getDroits().forEach(droit->{
				droits.add(droit.getName());
			});
			comptedto.setDroits(droits);
		}
		
		return comptedto;
	}

	public List<Comptesdto> ListCompteToListCompteDto (List<Comptes> comptes) {
		List<Comptesdto> comptesdto = new ArrayList<Comptesdto>();
		if (comptes != null) {
			comptes.forEach(compte->
				comptesdto.add(CompteEntityToCompteDto(compte))
			);
		}
		
		return comptesdto;
	}
}
