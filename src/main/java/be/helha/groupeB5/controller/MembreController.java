package be.helha.groupeB5.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupeB5.entities.Membre;
import be.helha.groupeB5.sessionejb.GestionMembreEJB;

@Named
@RequestScoped
public class MembreController {

	@EJB
	private GestionMembreEJB gestionMembreEJB;
	private String login, mdp, mail, prenom, nom, rue, ville, pays, nationalite, numGSM;
	private Date dateN;
	private int numRue, cp;
	
	public MembreController() {}
	
	public List<Membre> doAfficherMembre() {
		return gestionMembreEJB.selectAll();
	}
	
	public Membre doAjouterMembre() {
		Membre m = new Membre(login, mdp, mail, prenom, nom, rue, ville, pays, nationalite, numGSM, dateN, numRue, cp, false);
		return gestionMembreEJB.addMembre(m);
	}
	
	public Membre doModifierMembre() {
		return null;
	}
	/*
	public Membre doSupprimerMembre() {
		return gestionMembreEJB.deleteMembre(m);
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
	
	public String getNumGSM() {
		return numGSM;
	}

	public void setNumGSM(String numGSM) {
		this.numGSM = numGSM;
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
	
	
}
