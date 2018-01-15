package be.helha.groupeB5.sessionejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB5.entities.Membre;

@Remote
public interface IGestionMembreEJBRemote {
	List<Membre> selectAll();
	
	Membre addMembre(Membre m);
	
	Membre UpdateMembre(Membre m);
	
	Membre deleteMembre(Membre m);
	
	
	
	
}

