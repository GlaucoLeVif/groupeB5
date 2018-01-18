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

import be.helha.groupeB5.entities.Evenement;
import be.helha.groupeB5.entities.Membre;

@Stateless
@LocalBean
public class DAOMembreLocalBean {

	@PersistenceContext(unitName="groupeB5JTA")
	private EntityManager em;
	
	public DAOMembreLocalBean() {
		
	}
	
// Membre	
	public List<Membre> rechercherMembre() {
		String str = "SELECT m FROM Membre m";
		Query queryMembres = em.createQuery(str);
		List<Membre> list = (List<Membre>) queryMembres.getResultList();
		return list;
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
		Membre m1 = rechercherMembre(m);
		if(m1==null) {return;}
		Membre mModif = em.merge(m1);
		mModif.setListEvent(m.getListEvent());
	}
	
	public Membre rechercherMembre(Membre m)
	{
		String str = "SELECT m FROM Membre m WHERE m.login=:login";
		Query q = em.createQuery(str);
		q.setParameter("login", m.getLogin());
		List<Membre> result = (List<Membre>) q.getResultList();
		return result.get(0);
	}

	public Membre supprimerMembre(Membre m) {
		String str="Delete FROM Membre m WHERE m.idMembre=:idMembre";
		Query qAdr = em.createQuery(str);
		qAdr.setParameter("idMembre",m.getIdMembre());
		qAdr.executeUpdate();
		return m;
	}
	
	
// Evenement
	public List<Evenement> rechercherEvenement() {
		String str = "SELECT e FROM Evenement e";
		Query query = em.createQuery(str);
		List<Evenement> listE = (List<Evenement>) query.getResultList();
		
		/*
		List<Evenement> listE = new ArrayList<>();
		List<Object[]> results = this.em.createNativeQuery("SELECT * FROM Evenement e").getResultList();

		results.stream().forEach((record) -> {
		        int id =  (int) record[0];
		        Date dateEv = (Date) record[1];
		        byte barray[] = (byte[]) record[2];//((byte)(record[2])).getBytes()
		       // byte barray[] = Base64.getEncoder().encode((byte[])record[2]);
		        double objectif = (double) record[3];
		        double recolte = (double) record[4];
		        String resume = (String) record[5];
		        String titre = (String) record[6];
		        listE.add(new Evenement(titre, resume, barray, objectif, recolte, dateEv));
		        System.out.println(record[2].getClass().toString());
		        
		});*/
		
		return listE;
	}
	
	public Evenement ajouterEvenement(Evenement e) {
		System.out.println("stade3");
		if(isExistingEvenement(e.getTitre()))	return null;
		em.persist(e);
		return e;
	}
	
	public boolean isExistingEvenement(String titre) {
		String str = "SELECT e.idEv FROM Evenement e where e.titre =:titre";
		Query query = em.createQuery(str);
		query.setParameter("titre", titre);
		
		if(!query.getResultList().isEmpty()) {			
			return true;
		}
		return false;
	}
	
	public Evenement modifierEvenement(Evenement e) {
		return e;
	}
	
	public Evenement supprimerEvenement(Evenement e) {
		String strEvent = "Delete FROM Evenement e WHERE e.idEv=:idEv";
		Query qAdrEvent = em.createQuery(strEvent);
		qAdrEvent.setParameter("idEv",e.getIdEv());
		qAdrEvent.executeUpdate();
		return e;
	}
	
	
	
}
