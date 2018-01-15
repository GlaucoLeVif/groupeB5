package be.helha.sessionejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB5.entities.Membre;

@Remote
public interface IGestionMembreEJBRemote {
	List<Membre> selectAll();
	
	Membre addMembre(Membre p);
}
