package be.helha.groupeB5.sessionejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB5.entities.Evenement;

@Remote
public interface IGestionEvenementEJBRemote {
	List<Evenement> selectAll();
	
	List<Evenement> selectAllEtat(int etat);
	
	Evenement addEvenement(Evenement e);
	
	Evenement UpdateEvenement(Evenement e);
	
	Evenement deleteEvenement(Evenement e);
	
}
