package be.helha.groupeB5.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupeB5.entities.Evenement;
import be.helha.groupeB5.entities.Membre;
import be.helha.groupeB5.sessionejb.GestionEvenementEJB;

@Named
@RequestScoped
public class EvenementController {

	@EJB
	GestionEvenementEJB gestionEvenementEJB;
	private String titre, resume;
	private double objectif, recolte;
	private Date dateEv;
	private Evenement event = new Evenement();
	
	private byte[] image;
	
	public EvenementController() {}
	

	public List<Evenement> doAfficherEvenement() {
		System.out.println("salut");
		return gestionEvenementEJB.selectAll();
	}
	
	public Membre doModifierEvenement() {
		return null;
	}
	
	public Evenement doSupprimerEvenement(Evenement e) {
		return gestionEvenementEJB.deleteEvenement(e);
	}
	
	public String doDetails(Evenement e )
	{
		event = e;
		return "detailsEvenement.xhtml?faces-redirect=false";
	}
	
	public String doEvenement()
	{
		return "indexEvent.xhtml?faces-redirect=true";
	}
	
	
	public String doIndex()
	{
		return "index.xhtml?faces-redirect=true";
	}

	
	
	
	

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}

	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public double getObjectif() {
		return objectif;
	}
	public void setObjectif(double objectif) {
		this.objectif = objectif;
	}
	public double getRecolte() {
		return recolte;
	}
	public void setRecolte(double recolte) {
		this.recolte = recolte;
	}
	public Date getDateEv() {
		return dateEv;
	}
	public void setDateEv(Date dateEv) {
		this.dateEv = dateEv;
	}
	public Evenement getEvent() {
		return event;
	}
	public void setEvent(Evenement event) {
		this.event = event;
	}
	
	
	
	
}
