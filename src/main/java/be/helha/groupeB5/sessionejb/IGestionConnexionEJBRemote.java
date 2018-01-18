package be.helha.groupeB5.sessionejb;

import be.helha.groupeB5.entities.Membre;

public interface IGestionConnexionEJBRemote {
	
	Membre checkConnect(String login, String mdp);
	
}
