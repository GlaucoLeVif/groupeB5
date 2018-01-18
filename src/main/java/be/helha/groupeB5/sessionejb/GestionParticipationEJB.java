package be.helha.groupeB5.sessionejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.groupeB5.dao.DAOMembreLocalBean;
import be.helha.groupeB5.dao.DAOParticipationLocalBean;
import be.helha.groupeB5.entities.Membre;
import be.helha.groupeB5.entities.Participation;

@Stateless
@LocalBean
public class GestionParticipationEJB implements IGestionParticiptionEJBRemote{

	@EJB
	private DAOParticipationLocalBean dao;//Jamais de NEW
	
	@Override
	public List<Participation> selectAll() {
		return dao.rechercherParticipation();
	}

	@Override
	public Participation addParticipation(Participation p) {
		return dao.ajouterParticipation(p);
	}

	@Override
	public Participation deleteParticipation(Participation p) {
		return dao.supprimerParticipation(p);
	}

}
