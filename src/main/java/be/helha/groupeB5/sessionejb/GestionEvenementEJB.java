package be.helha.groupeB5.sessionejb;

import java.util.List;

import javax.ejb.EJB;

import be.helha.groupeB5.dao.DAOMembreLocalBean;
import be.helha.groupeB5.entities.Evenement;

public class GestionEvenementEJB implements IGestionEvenementEJBRemote{

	@EJB
	private DAOMembreLocalBean dao;//Jamais de NEW
	
	
	@Override	
	public List<Evenement> selectAll() {
		return dao.rechercherEvenement();
	}

	@Override
	public Evenement addEvenement(Evenement e) {
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
