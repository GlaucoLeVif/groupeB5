package be.helha.groupeB5.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		Date d = new Date();
		Date d2 = new Date();
		Date d3 = new Date();
		Date d4 = new Date();
		Date d5 = new Date();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d = format.parse("05/02/1997");
			d2 = format.parse("01/02/2018");
			d3 = format.parse("02/02/2018");
			d4 = format.parse("01/01/2018");
			d5 = format.parse("02/01/2018");
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		Membre m = new Membre("log", "mdp", "monmail", "distant", "Led", "place", "Beaumont", "Belgique", "BE", "0492", d, "1", 6500, false);
		Evenement e = new Evenement("titre1", "resume1", "url1", 5000.00, 0, d2);
		Evenement e2 = new Evenement("titre2", "resume2", "url2", 100000.00, 0, d3);
		
		Participation p = new Participation(20, d4,m,e);
		Participation p2 = new Participation(40, d5,m,e2);

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
