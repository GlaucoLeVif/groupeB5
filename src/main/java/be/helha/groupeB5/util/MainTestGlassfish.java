package be.helha.groupeB5.util;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.groupeB5.entities.Membre;

public class MainTestGlassfish {
	public static void main(String[] args) {
		Membre user1 = new Membre("loginA", "mdpA", "emailA", "prenomA", "nomA", "rueA", "villeA", "paysA", "nationaliteA", "rueA", new Date(), 1, 1, false);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("groupeB5");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
			em.persist(user1);
		tx.commit();

		em.close();
		emf.close();
	}
}
