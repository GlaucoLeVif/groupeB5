package be.helha.groupeB5.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.groupeB5.entities.Membre;

@Stateless
@LocalBean
public class DAOMembreLocalBean {

	@PersistenceContext(unitName="groupeB5JTA")
	private EntityManager em;
	
	public DAOMembreLocalBean() {
		
	}
	
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
		String str = "SELECT m.id FROM Membre m where m.login =:login";
		Query queryProprio = em.createQuery(str);
		queryProprio.setParameter("login", login);
		
		if(!queryProprio.getResultList().isEmpty()) {			
			return true;
		}
		return false;
	}
	
	public Membre modifierMembre(Membre m) {
		return m;
	}
	
	public Membre supprimerMembre(Membre m) {
		String str="Delete FROM Membre u WHERE u.login=:login";
		Query qAdr = em.createQuery(str);
		qAdr.setParameter("login",m.getLogin());
		qAdr.executeUpdate();
		return m;
	}
	
	
}
