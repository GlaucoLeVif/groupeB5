package be.helha.groupeB5.util;


import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import be.helha.groupeB5.entities.Evenement;
import be.helha.groupeB5.entities.Membre;
import be.helha.groupeB5.entities.Participation;

public class MainData {

	public static void main(String[] args) {

		Date d = new Date(1997, 4, 14);
		Membre m = new Membre("log", "mdp", "monmail", "distant", "Led", "place", "Beaumont", "Belgique", "BE", "0492", d, 1, 6500, false);	// PQ numGSM en String
		Evenement e = new Evenement("titre1", "resume1", "url1", 5000.00, 0, new Date(2018,7,14));
		Evenement e2 = new Evenement("titre2", "resume2", "url2", 100000.00, 0, new Date(2018,8,12));
		
		Participation p = new Participation(20, new Date(2018,2,02),m,e);
		Participation p2 = new Participation(40, new Date(2018,3,04),m,e2);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("groupeB5");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(m);
		em.persist(e);
		em.persist(e2);
		em.persist(p);
		em.persist(p2);
		tx.commit();
		
		String jpqlQuery = "SELECT m FROM Membre m";
		Query query = em.createQuery(jpqlQuery);
		
		System.out.println("RESULT LIST" +query.getResultList());
		
		em.close();
		emf.close();
		
	}

}
