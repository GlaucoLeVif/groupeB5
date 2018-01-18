package be.helha.groupeB5.sessionejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.groupeB5.controller.ConnexionController;
import be.helha.groupeB5.dao.DAOMembreLocalBean;
import be.helha.groupeB5.entities.Evenement;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Stateless
@LocalBean
public class GestionEvenementEJB implements IGestionEvenementEJBRemote{

	@EJB
	private DAOMembreLocalBean dao;//Jamais de NEW
	
	
	@Override	
	public List<Evenement> selectAll() {
		return dao.rechercherEvenement();
	}

	@Override
	public Evenement addEvenement(Evenement e) {
		System.out.println("stade2");
		return dao.ajouterEvenement(e);
	}

	@Override
	public Evenement UpdateEvenement(Evenement e) {
		return dao.modifierEvenement(e);
	}

	@Override
	public Evenement deleteEvenement(Evenement e) {
		return dao.supprimerEvenement(e);
	}

}
