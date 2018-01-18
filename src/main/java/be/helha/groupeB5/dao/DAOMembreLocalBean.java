package be.helha.groupeB5.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import be.helha.groupeB5.controller.ConnexionController;
import be.helha.groupeB5.entities.Evenement;
import be.helha.groupeB5.entities.Membre;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Stateless
@LocalBean
public class DAOMembreLocalBean {

	@PersistenceContext(unitName="groupeB5JTA")
	private EntityManager em;
	
	public DAOMembreLocalBean() {}
	
// Membre	
	public List<Membre> rechercherMembre() {
		if(!ConnexionController.getMembre().equals(null)) {
			try {
			    Jwts.parser().setSigningKey(ConnexionController.getKey()).parseClaimsJws(ConnexionController.getToken());
			    String str = "SELECT m FROM Membre m";
				Query queryMembres = em.createQuery(str);
				List<Membre> list = (List<Membre>) queryMembres.getResultList();
				return list;
				
			} catch (SignatureException e) {
				System.out.println("pas de token");
			    return null;
			}
		}else {
			return null;
		}
	}
	
	public Membre ajouterMembre(Membre m) {
		if(isExistingMembre(m.getLogin()))	return null;
		em.persist(m);
		return m;
	}
	
	public boolean isExistingMembre(String login) {
		String str = "SELECT m.idMembre FROM Membre m where m.login =:login";
		Query query = em.createQuery(str);
		query.setParameter("login", login);
		
		if(!query.getResultList().isEmpty()) {			
			return true;
		}
		return false;
	}
	
	public void modifierMembre(Membre m) {
		System.out.println("stade3");
		System.out.println(m.toString());
/*
		Membre m1 = rechercherMembre(m);
		if(m1==null) {return;}
		Membre mModif = em.merge(m1);
		mModif.setListEvent(m.getListEvent());*/
		em.merge(m);
		//for(int i = 0;i <mModif.getListEvent().size();i++)
		//	System.out.println(mModif.getListEvent().get(i).toString());
	}
	
	public Membre rechercherMembre(Membre m)
	{
		String str = "SELECT m FROM Membre m WHERE m.login=:login";
		Query q = em.createQuery(str);
		q.setParameter("login", m.getLogin());
		List<Membre> result = (List<Membre>) q.getResultList();
		return result.get(0);
	}
	
	public List<Membre> checkConnect(String login, String mdp) {
		String str = "SELECT m FROM Membre m where m.login =:login and m.mdp =:mdp";
		Query query = em.createQuery(str);
		query.setParameter("login", login);
		query.setParameter("mdp", mdp);
		
		return (List<Membre>)query.getResultList();
	}

	public Membre supprimerMembre(Membre m) {
		String str="Delete FROM Membre m WHERE m.idMembre=:idMembre";
		Query qAdr = em.createQuery(str);
		qAdr.setParameter("idMembre",m.getIdMembre());
		qAdr.executeUpdate();
		return m;
	}
	
	
	
	
	
}
