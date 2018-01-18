package be.helha.groupeB5.sessionejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.groupeB5.dao.DAOMembreLocalBean;
import be.helha.groupeB5.entities.Membre;

@Stateless
@LocalBean
public class GestionConnexionEJB {
	
	@EJB
	private DAOMembreLocalBean dao;
	
	public List<Membre> checkConnect(String login, String mdp) {
		List<Membre> m=dao.checkConnect(login, mdp);
		return m;
	}
}
