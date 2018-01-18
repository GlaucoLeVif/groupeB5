package be.helha.groupeB5.sessionejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB5.entities.Evenement;
import be.helha.groupeB5.entities.Membre;

@Remote
public interface IGestionMembreEJBRemote {
	List<Membre> selectAll();
	
	List<Evenement> displayMyEvenements(Membre m);
	
	Membre addMembre(Membre m);
	
	void UpdateMembre(Membre m);
	
	Membre deleteMembre(Membre m);
	
	
	
}

