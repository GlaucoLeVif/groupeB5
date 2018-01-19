package be.helha.groupeB5.controller;

import java.security.Key;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import be.helha.groupeB5.entities.Membre;
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
	
	private boolean connecte;
	
	public void test() {
		connecte=!connecte;
	}

	public String connect() {
		List<Membre> m=gestionConnexionEJB.checkConnect(login, mdp);
		if(!m.isEmpty()) {
			System.out.println("connexion ok");
			if(token==null) {
				key = MacProvider.generateKey();
			}
			token = Jwts.builder()
			  .setSubject("Joe")
			  .signWith(SignatureAlgorithm.HS512, key)
			  .compact();
			connecte=true;
			membre = m.get(0);
			System.out.println(connecte);
			
			return "index.xhtml?faces-redirect=true";
		}
		return "";
	}
	
	public void refreshMembre() {
		membre=gestionConnexionEJB.checkConnect(login, mdp).get(0);
	}
	
	public String disconnect() {
		key=null;
		token=null;
		membre=null;
		login=null;
		mdp=null;
		connecte=false;
		return "index.xhtml";
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

	public  void setMembre(Membre membre) {
		membre = membre;
	}

	public static String getToken() {
			return token;
	}

	public  void setToken(String token) {
		this.token = token;
	}

	public static Key getKey() {
		if(key==null) {
			return key = MacProvider.generateKey();
		}
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public boolean getConnecte() {
		return connecte;
	}

	public void setConnecte(boolean connecte) {
		this.connecte = connecte;
	}
}
