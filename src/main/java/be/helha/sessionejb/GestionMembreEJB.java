package be.helha.sessionejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.groupeB5.dao.DAOMembreLocalBean;
import be.helha.groupeB5.entities.Membre;

@Stateless
@LocalBean
public class GestionMembreEJB implements IGestionMembreEJBRemote{

	@EJB
	private DAOMembreLocalBean dao;//Jamais de NEW
	
	
	@Override	
	public List<Membre> selectAll() {
		return dao.rechercherMembre();
	}

	@Override
	public Membre addMembre(Membre m) {
		dao.ajouterMembre(m);
		return m;
	}
}
