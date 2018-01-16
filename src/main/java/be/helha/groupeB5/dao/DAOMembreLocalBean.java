package be.helha.groupeB5.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	public Membre modifierMembre(Membre m) {
		return m;
	}
	
	public Membre supprimerMembre(Membre m) {
		String str="Delete FROM Membre m WHERE m.login=:login";
		Query qAdr = em.createQuery(str);
		qAdr.setParameter("login",m.getLogin());
		qAdr.executeUpdate();
		return m;
	}
	
	
// Evenement	
	public List<Evenement> rechercherEvenement() {
		String str = "SELECT e FROM Evenement e";
		Query query = em.createQuery(str);
		List<Evenement> list = (List<Evenement>) query.getResultList();
		return list;
	}
	
	public Evenement ajouterEvenement(Evenement e) {
		if(isExistingEvenement(e.getTitre()))	return null;
		em.persist(e);
		return e;
	}
	
	public boolean isExistingEvenement(String titre) {
		String str = "SELECT e.idEvenement FROM Evenement e where e.titre =:titre";
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
		String str="Delete FROM Evenement m WHERE m.titre=:titre";
		Query qAdr = em.createQuery(str);
		qAdr.setParameter("titre",e.getTitre());
		qAdr.executeUpdate();
		return e;
	}
	
}
