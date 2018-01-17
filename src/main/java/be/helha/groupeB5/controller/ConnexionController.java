package be.helha.groupeB5.controller;

import java.security.Key;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupeB5.entities.Membre;
import be.helha.groupeB5.entities.MembreConnecte;
import be.helha.groupeB5.sessionejb.GestionConnexionEJB;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Named
@RequestScoped
public class ConnexionController {
	
	@EJB
	private GestionConnexionEJB gestionConnexionEJB;
	
	private String login, mdp;
	private Membre m;
	private String token;
	private Key key;

	public Membre connect() {
		List<Membre> m=gestionConnexionEJB.checkConnect(login, mdp);
		if(!m.isEmpty()) {
			System.out.println("compte existe");
			if(token==null) {
				key = MacProvider.generateKey();
				MembreConnecte.getInstance().setKey(key);
			}
			token = Jwts.builder()
			  .setSubject("Joe")
			  .signWith(SignatureAlgorithm.HS512, key)
			  .compact();
			MembreConnecte.getInstance().setToken(token);
			MembreConnecte.getInstance().setM(m.get(0));
			return m.get(0);
		}
		return null;
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
}
