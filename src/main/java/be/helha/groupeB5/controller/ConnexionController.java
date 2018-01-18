package be.helha.groupeB5.controller;

import java.security.Key;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import be.helha.groupeB5.entities.Membre;
import be.helha.groupeB5.entities.MembreConnecte;
import be.helha.groupeB5.sessionejb.GestionConnexionEJB;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@ManagedBean  
@SessionScoped
public class ConnexionController {
	
	@EJB
	private GestionConnexionEJB gestionConnexionEJB;
	
	private String login, mdp;
	private static Membre membre;
	private static String token="";
	private static Key key= MacProvider.generateKey();
	
	private boolean isConnecte;
	
	private String boutonConnecte;

	public String connect() {
		List<Membre> m=gestionConnexionEJB.checkConnect(login, mdp);
		if(!m.isEmpty()) {
			if(token==null) {
				key = MacProvider.generateKey();
			}
			token = Jwts.builder()
			  .setSubject("Joe")
			  .signWith(SignatureAlgorithm.HS512, key)
			  .compact();
			isConnecte=true;
			membre = m.get(0);
			toggleConnecte();
			
			return "index.xhtml";
		}
		return "";
	}
	
	public void disconnect() {
		key=null;
		token=null;
		membre=null;
		login=null;
		mdp=null;
		isConnecte=false;
	}
	
	public void toggleConnecte() {
		if(isConnecte){
			boutonConnecte = "Déconnexion";
		}else {
			boutonConnecte = "Connexion";
		}
	}
	
	public String goIndex() {
		return "index.xhtml";
	}
	
	public String goListEvent() {
		return "indexEvent.xhtml";
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public GestionConnexionEJB getGestionConnexionEJB() {
		return gestionConnexionEJB;
	}

	public void setGestionConnexionEJB(GestionConnexionEJB gestionConnexionEJB) {
		this.gestionConnexionEJB = gestionConnexionEJB;
	}

	public static Membre getMembre() {
		return membre;
	}

	public static void setMembre(Membre membre) {
		membre = membre;
	}

	public static String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public boolean getIsConnecte() {
		return isConnecte;
	}

	public void setIsConnecte(boolean isConnecte) {
		this.isConnecte = isConnecte;
	}

	public String getBoutonConnecte() {
		return boutonConnecte;
	}

	public void setBoutonConnecte(String connecte) {
		this.boutonConnecte = connecte;
	}
}
