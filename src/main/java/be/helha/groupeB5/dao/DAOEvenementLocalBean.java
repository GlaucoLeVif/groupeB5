package be.helha.groupeB5.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.groupeB5.entities.Evenement;

@Stateless
@LocalBean
public class DAOEvenementLocalBean {

	@PersistenceContext(unitName="groupeB5JTA")
	private EntityManager em;
	
	
	public DAOEvenementLocalBean() {}
	
	
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
	
	public List<Evenement> rechercherEvenementEtat( int etat)
	{
		String str = "SELECT e FROM Evenement e WHERE e.etat=:etat";
		Query query = em.createQuery(str);
		query.setParameter("etat", etat);
		List<Evenement> listE = (List<Evenement>) query.getResultList();
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
