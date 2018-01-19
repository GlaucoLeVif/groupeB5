package be.helha.groupeB5.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupeB5.entities.Evenement;
import be.helha.groupeB5.entities.Membre;
import be.helha.groupeB5.sessionejb.GestionMembreEJB;

@Named
@RequestScoped
public class MembreController {

	@EJB
	private GestionMembreEJB gestionMembreEJB;
	private String login, mdp, mail, prenom, nom, rue,numRue, ville, pays, nationalite, numGSM;
	private Date dateN;
	private int cp;
	private Membre membre = new Membre();
	private List<Evenement> listEvent;
	
	public MembreController() {}
	
	public List<Membre> doAfficherMembre() {
		return gestionMembreEJB.selectAll();
	}
	
	public Membre doAjouterMembre() {
		Membre m = new Membre(login, mdp, mail, prenom, nom, rue, ville, pays, nationalite, numGSM, dateN, numRue, cp, false);
		return gestionMembreEJB.addMembre(m);
	}
	
	public void doModifierMembre() {
		gestionMembreEJB.UpdateMembre(ConnexionController.getMembre());
	}
	
	public Membre doSupprimerMembre(Membre m) {
		return gestionMembreEJB.deleteMembre(m);
	}
	
	public List<Evenement> doAfficherMesEvenements(){
		List<Evenement> listTmpARemplir = new ArrayList<>();
		List<Evenement> listTmp2 = gestionMembreEJB.displayMyEvenements(ConnexionController.getMembre());
		System.out.println(listTmp2.size());
		for(int i=0;i<listTmp2.size();i++)
		{
			System.out.println("Je passe - 1 size "+listTmp2.size());
			if(listTmp2.get(i).getEtat()==1)
			{
				System.out.println("Je passe - 2");
				listTmpARemplir.add(listTmp2.get(i));
			}
		}
		System.out.println("Je passe - 3");
		return listTmpARemplir;
	}
	
	public String doDetails(Membre m)
	{
		membre = m;
		return "detailsMembre.xhtml?faces-redirect=false";
	}
	
	
	public String doList()
	{
		return "listeMembre.xhtml?faces-redirect=true";
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

	public String getNumRue() {
		return numRue;
	}
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public Membre getMembre() {
		return membre;
	}
	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	public List<Evenement> getListEvent() {
		return listEvent;
	}
	public void setListEvent(List<Evenement> listEvent) {
		this.listEvent = listEvent;
	}
	
	
}
