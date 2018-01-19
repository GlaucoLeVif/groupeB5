package be.helha.groupeB5.sessionejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.groupeB5.controller.ConnexionController;
import be.helha.groupeB5.dao.DAOMembreLocalBean;
import be.helha.groupeB5.entities.Evenement;
import be.helha.groupeB5.entities.Membre;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Stateless
@LocalBean
public class GestionMembreEJB implements IGestionMembreEJBRemote{

	@EJB
	private DAOMembreLocalBean dao;//Jamais de NEW
	
	
	@Override	
	public List<Membre> selectAll() {
		try {
		    Jwts.parser().setSigningKey(ConnexionController.getKey()).parseClaimsJws(ConnexionController.getToken());

			return dao.rechercherMembre();
		} catch (SignatureException er) {
		    return null;
		}
	}

	@Override
	public List<Evenement> displayMyEvenements(Membre m) {
		
		try {
		    Jwts.parser().setSigningKey(ConnexionController.getKey()).parseClaimsJws(ConnexionController.getToken());
		    return dao.afficherMesEvenements(m);
		} catch (SignatureException er) {
		    return null;
		}
	}

	@Override
	public Membre addMembre(Membre m) {
		return dao.ajouterMembre(m);
	}

	@Override
	public void UpdateMembre(Membre m) {
		System.out.println("stade2");
		System.out.println(m.toString());
		dao.modifierMembre(m);
	}

	@Override
	public Membre deleteMembre(Membre m) {
		return dao.supprimerMembre(m);
	}
	
	
	
	
}
