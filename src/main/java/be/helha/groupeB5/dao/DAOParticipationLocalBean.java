package be.helha.groupeB5.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.groupeB5.entities.Membre;
import be.helha.groupeB5.entities.Participation;

@Stateless
@LocalBean
public class DAOParticipationLocalBean {

	@PersistenceContext(unitName="groupeB5JTA")
	private EntityManager em;
	
	public DAOParticipationLocalBean() {}
	
// Participation
	public List<Participation> rechercherParticipation() {
		String str = "SELECT p FROM Participation p";
		Query query = em.createQuery(str);
		List<Participation> list = (List<Participation>) query.getResultList();
		return list;
	}
	
	public Participation ajouterParticipation(Participation p) {
		em.persist(p);
		return p;
	}

	public Participation supprimerParticipation(Participation p) {
		String str="Delete FROM Participation p WHERE p.idP=:idP";
		Query qAdr = em.createQuery(str);
		qAdr.setParameter("idP",p.getIdP());
		qAdr.executeUpdate();
		return p;
	}
}
