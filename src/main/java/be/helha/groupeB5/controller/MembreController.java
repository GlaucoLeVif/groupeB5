package be.helha.groupeB5.controller;

import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupeB5.entities.Membre;

@Named
@RequestScoped
public class MembreController {

	@EJB
//	private GestionMembreEJB gestionMembreEJB;
	private String login, mdp, mail, prenom, nom, rue, ville, pays, nationalite, numeroGSM;
	private Date dateN;
	private int numRue, cp;
	private boolean isAdmin;
	
	public MembreController() {}
	
/*	
	public Membre doAjouterMembre() {
		Membre m = new Membre(login, mdp, mail, prenom, nom, rue, ville, pays, nationalite, numeroGSM, dateN, numRue, cp, isAdmin);
		return gestionMembreEJB.ajouterMembre(m);
	}
*/	
	
	
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

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNumeroGSM() {
		return numeroGSM;
	}
	public void setNumeroGSM(String numeroGSM) {
		this.numeroGSM = numeroGSM;
	}

	public Date getDateN() {
		return dateN;
	}
	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}

	public int getNumRue() {
		return numRue;
	}
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
