package be.helha.groupeB5.sessionejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.groupeB5.controller.ConnexionController;
import be.helha.groupeB5.dao.DAOEvenementLocalBean;
import be.helha.groupeB5.dao.DAOMembreLocalBean;
import be.helha.groupeB5.entities.Evenement;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Stateless
@LocalBean
public class GestionEvenementEJB implements IGestionEvenementEJBRemote{

	@EJB
	private DAOEvenementLocalBean dao;//Jamais de NEW
	
	@Override	
	public List<Evenement> selectAll() {
		    return dao.rechercherEvenement();
	}
	
	@Override
	public List<Evenement> selectAllEtat(int etat)
	{
		return dao.rechercherEvenementEtat(etat);
	}

	@Override
	public Evenement addEvenement(Evenement e) {
		try {
		    Jwts.parser().setSigningKey(ConnexionController.getKey())
		    	.parseClaimsJws(ConnexionController.getToken());
		    return dao.ajouterEvenement(e);
		} catch (SignatureException er) {
		    return null;
		}
	}

	@Override
	public Evenement UpdateEvenement(Evenement e) {
		try {
		    Jwts.parser().setSigningKey(ConnexionController.getKey()).parseClaimsJws(ConnexionController.getToken());
		    return dao.modifierEvenement(e);
		} catch (SignatureException er) {
		    return null;
		}
	}

	@Override
	public Evenement deleteEvenement(Evenement e) {
		try {
		    Jwts.parser().setSigningKey(ConnexionController.getKey()).parseClaimsJws(ConnexionController.getToken());
		    return dao.supprimerEvenement(e);
		} catch (SignatureException er) {
		    return null;
		}
	}
}
