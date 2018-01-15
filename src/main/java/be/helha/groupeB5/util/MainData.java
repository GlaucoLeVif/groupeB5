package be.helha.groupeB5.util;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import be.helha.groupeB5.entities.Membre;

public class MainData {

	public static void main(String[] args) {

		Date d = new Date(1997, 04, 14);
		Membre m = new Membre("log", "mdp", "monmail", "Florian", "Led", "place", "Beaumont", "Belgique", "BE", "0492", d, 1, 6500, false);	// PQ numGSM en String
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("groupeB5");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(m);
		tx.commit();
		
		String jpqlQuery = "SELECT m FROM Membre m";
		Query query = em.createQuery(jpqlQuery);
		
		System.out.println("RESULT LIST" +query.getResultList());
		
		em.close();
		emf.close();
		
	}

}
