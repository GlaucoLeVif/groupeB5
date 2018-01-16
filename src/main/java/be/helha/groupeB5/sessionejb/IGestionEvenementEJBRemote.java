package be.helha.groupeB5.sessionejb;

import java.util.List;

import be.helha.groupeB5.entities.Evenement;

public interface IGestionEvenementEJBRemote {
	List<Evenement> selectAll();
	
	Evenement addEvenement(Evenement e);
	
	Evenement UpdateEvenement(Evenement e);
	
	Evenement deleteEvenement(Evenement e);
	
}
